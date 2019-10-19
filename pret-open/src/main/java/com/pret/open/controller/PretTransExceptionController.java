package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransExceptionBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretTransPlanRepository;
import com.pret.open.repository.PretVenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.service.PretTransExceptionService;

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