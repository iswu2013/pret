package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransFeeBo;
import com.pret.open.entity.bo.PretTransPlanSignBo;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretTransFeeService;
import com.pret.open.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFee")
public class PretTransFeeController extends BaseManageController<PretTransFeeService, PretTransFee, PretTransFeeVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransFeeItemRepository pretTransFeeItemRepository;
    @Autowired
    private PretFeeTypeRepository pretFeeTypeRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransFeeVo request, PretTransFee t) {
        if (request.isSearchStatus()) {
            List<Integer> statusList = new ArrayList<>();
            statusList.add(ConstantEnum.EPretTransFeeStatus.已申报.getLabel());
            statusList.add(ConstantEnum.EPretTransFeeStatus.待申报.getLabel());
            statusList.add(ConstantEnum.EPretTransFeeStatus.审核通过.getLabel());
            request.setIn$status(statusList);
        }
        if(!StringUtils.isEmpty(request.getUserId())) {
            request.setIn$deptId(userService.getDeptIdListByUserId(request.getUserId()));
        }
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
            PretTransPlan pretTransPlan = pretTransPlanRepository.findById(transFee.getTransPlanId()).get();
            transFee.setPretTransPlan(pretTransPlan);
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
            List<PretTransFeeItem> pretTransFeeItemList = pretTransFeeItemRepository.findByTransFeeIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            for (PretTransFeeItem pretTransFeeItem : pretTransFeeItemList) {
                PretFeeType pretFeeType = pretFeeTypeRepository.findById(pretTransFeeItem.getFeeTypeId()).get();
                pretTransFeeItem.setPretFeeType(pretFeeType);
            }
            item.setPretTransFeeItemList(pretTransFeeItemList);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("编辑费用")
    @PostMapping("/editTransFee")
    public void editTransFee(PretTransFeeBo bo) throws FebsException {
        try {
            this.service.editTransFee(bo);
        } catch (Exception e) {
            throw new FebsException(e.getMessage());
        }
    }

}