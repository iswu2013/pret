package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.StringUtil;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransFeeItemRepository pretTransFeeItemRepository;
    @Autowired
    private PretFeeTypeRepository pretFeeTypeRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private UserService userService;
    @Value("${upload.baseurl}")
    private String baseurl;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransFeeVo request, PretTransFee t) {
        if (!StringUtils.isEmpty(request.getUserId())) {
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
            Optional<PretTransPlan> pretTransPlanOptional = pretTransPlanRepository.findById(transFee.getTransPlanId());
            if (pretTransPlanOptional.isPresent()) {
                transFee.setPretTransPlan(pretTransPlanOptional.get());
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
            List<PretTransFeeItem> pretTransFeeItemList = pretTransFeeItemRepository.findByTransFeeIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            for (PretTransFeeItem pretTransFeeItem : pretTransFeeItemList) {
                if (pretTransFeeItem.getCalType() == ConstantEnum.ECalType.自动计费.getLabel()) {
                    PretFeeType pretFeeType = pretFeeTypeRepository.findById(pretTransFeeItem.getFeeTypeId()).get();
                    pretTransFeeItem.setPretFeeType(pretFeeType);
                }
            }
            item.setPretTransFeeItemList(pretTransFeeItemList);
            PretTransPlan pretTransPlan = pretTransPlanRepository.findById(item.getTransPlanId()).get();
            item.setPretTransPlan(pretTransPlan);
            if (!StringUtils.isEmpty(pretTransPlan.getImages())) {
                pretTransPlan.setImageList(StringUtil.idsStr2ListStringAddPrefix(pretTransPlan.getImages(), baseurl));
            }

            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransPlanIdAndS(item.getTransPlanId(), ConstantEnum.S.N.getLabel());
            item.setPretTransOrderList(pretTransOrderList);
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

    @Log("编辑异常费用费用")
    @PostMapping("/editExceptionTransFee")
    public void editExceptionTransFee(PretTransFeeBo bo) throws FebsException {
        try {
            this.service.editExceptionTransFee(bo);
        } catch (Exception e) {
            throw new FebsException(e.getMessage());
        }
    }

}