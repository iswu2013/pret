package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretTransStatementService;
import com.pret.open.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransStatementC")
public class PretTransStatementCController extends BaseManageController<PretTransStatementService, PretTransStatement, PretTransStatementVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransStatementVo request, PretTransStatement t) {
        if(!StringUtils.isEmpty(request.getUserId())) {
            request.setIn$deptId(userService.getDeptIdListByUserId(request.getUserId()));
        }
        Page<PretTransStatement> page = this.service.page(request);
        for (PretTransStatement transStatement : page.getContent()) {
            if (!StringUtils.isEmpty(transStatement.getBillToId())) {
                PretVender pretVender = pretVenderRepository.findById(transStatement.getBillToId()).get();
                transStatement.setPretVender(pretVender);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransStatement view(@PathVariable String id) throws FebsException {
        try {
            PretTransStatement item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("对账确认")
    @PostMapping("/{ids}/{username}")
    public void confirmStatement(@PathVariable String ids,@PathVariable String username) throws FebsException {
        try {
            this.service.confirmStatement(ids,username);
        } catch (Exception e) {
            message = "对账确认失败";
            throw new FebsException(message);
        }
    }
}