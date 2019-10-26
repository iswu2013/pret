package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransException;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.PretTransExceptionBo;
import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretTransPlanRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretTransExceptionService;
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
@RequestMapping("pretTransException")
public class PretTransExceptionController extends BaseManageController<PretTransExceptionService, PretTransException, PretTransExceptionVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransException view(@PathVariable String id) throws FebsException {
        try {
            PretTransException item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransExceptionVo request, PretTransException t) {
        Page<PretTransException> page = this.service.page(request);
        for (PretTransException orgin : page.getContent()) {
            if (!StringUtils.isEmpty(orgin.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(orgin.getVenderId()).get();
                orgin.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(orgin.getTransPlanId())) {
                PretTransPlan pretTransPlan = pretTransPlanRepository.findById(orgin.getTransPlanId()).get();
                orgin.setPretTransPlan(pretTransPlan);
            }

            if (!StringUtils.isEmpty(orgin.getTransOrderId())) {
                PretTransOrder pretTransOrder = pretTransOrderRepository.findById(orgin.getTransOrderId()).get();
                orgin.setPretTransOrder(pretTransOrder);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("生成异常单")
    @PostMapping("/genPretTransException")
    public void genPretTransException(PretTransExceptionBo bo) throws FebsException {
        try {
            this.service.genPretTransException(bo);
        } catch (Exception e) {
            message = "生成异常单失败";
            throw new FebsException(message);
        }
    }
}