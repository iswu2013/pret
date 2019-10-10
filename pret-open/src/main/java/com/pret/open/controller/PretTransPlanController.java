package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretTransPlanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransPlan")
public class PretTransPlanController extends BaseManageController<PretTransPlanService, PretTransPlan, PretTransPlanVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransPlanVo request, PretTransPlan t) {
        Page<PretTransPlan> page = this.service.page(request);
        for (PretTransPlan transPlan : page.getContent()) {
            if (!StringUtils.isEmpty(transPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(transPlan.getVenderId()).get();
                transPlan.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(transPlan.getCustomerId())) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(transPlan.getCustomerId()).get();
                transPlan.setPretCustomer(pretCustomer);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }


    @Log("生成运输计划")
    @PostMapping("/pretTransPlanAdd")
    public void pretTransPlanAdd(PretTransPlanBo bo) throws FebsException {
        try {
            this.service.pretTransPlanAdd(bo);
        } catch (Exception e) {
            message = "生成运输计划失败";
            throw new FebsException(message);
        }
    }
}