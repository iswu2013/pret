package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.FebsException;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretVenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.service.PretTransFeeService;

import java.util.*;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFee")
public class PretTransFeeController extends BaseManageController<PretTransFeeService, PretTransFee, PretTransFeeVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;

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

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransFeeVo request, PretTransFee t) {
        Page<PretTransFee> page = this.service.page(request);
        for (PretTransFee transFee : page.getContent()) {
            if (!StringUtils.isEmpty(transFee.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(transFee.getVenderId()).get();
                transFee.setPretVender(pretVender);
            }
            if(!StringUtils.isEmpty(transFee.getCustomerId())) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(transFee.getCustomerId()).get();
                transFee.setPretCustomer(pretCustomer);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

}