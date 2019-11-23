package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretServiceRouteOriginRepository;
import com.pret.open.repository.PretTransPlanRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretTransFeeService;
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
@RequestMapping("pretTransFeeAppl")
public class PretTransFeeApplController extends BaseManageController<PretTransFeeService, PretTransFee, PretTransFeeVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransFeeVo request, PretTransFee t) {
        Page<PretTransFee> page = this.service.page(request);
        for (PretTransFee transFee : page.getContent()) {
            if (!StringUtils.isEmpty(transFee.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(transFee.getVenderId()).get();
                transFee.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(transFee.getCustomerId())) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(transFee.getCustomerId()).get();
                transFee.setPretCustomer(pretCustomer);
            }
            if (!StringUtils.isEmpty(transFee.getTransPlanId())) {
                PretTransPlan pretTransPlan = pretTransPlanRepository.findById(transFee.getTransPlanId()).get();
                transFee.setPretTransPlan(pretTransPlan);

                if (!StringUtils.isEmpty(pretTransPlan.getServiceRouteOriginId())) {
                    PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(pretTransPlan.getServiceRouteOriginId()).get();
                    transFee.setPretServiceRouteOrigin(pretServiceRouteOrigin);
                }
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransFee view(@PathVariable String id) throws FebsException {
        try {
            PretTransFee item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("费用申报")
    @PostMapping("/{ids}")
    public void sign(@PathVariable String ids) throws FebsException {
        try {
            this.service.transFeeAppl(ids);
        } catch (Exception e) {
            message = "费用申报失败";
            throw new FebsException(message);
        }
    }
}