package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.bo.PretTransPlanStartShipmentConfirmBo;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretTransPlanService;
import com.pret.open.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private PretDriverRepository pretDriverRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;
    @Autowired
    private UserService userService;
    @Value("${upload.baseurl}")
    private String baseurl;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransPlanVo request, PretTransPlan t) {
        if (!StringUtils.isEmpty(request.getUserId())) {
            request.setIn$deptId(userService.getDeptIdListByUserId(request.getUserId()));
        }
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
            if (!StringUtils.isEmpty(transPlan.getDriverId())) {
                PretDriver pretDriver = pretDriverRepository.findById(transPlan.getDriverId()).get();
                transPlan.setPretDriver(pretDriver);
            }
            if (!StringUtils.isEmpty(transPlan.getServiceRouteOriginId())) {
                PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(transPlan.getServiceRouteOriginId()).get();
                transPlan.setPretServiceRouteOrigin(pretServiceRouteOrigin);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransPlan view(@PathVariable String id) throws FebsException {
        try {
            PretTransPlan item = this.service.findById(id).get();
            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransPlanIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            item.setPretTransOrderList(pretTransOrderList);
            if (!StringUtils.isEmpty(item.getImages())) {
                item.setImageList(StringUtil.idsStr2ListStringAddPrefix(item.getImages(), baseurl));
            }
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
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

    @Log("起运确认")
    @PostMapping("/pretStartShipmentConfirm")
    public void pretStartShipmentConfirm(PretTransPlanStartShipmentConfirmBo bo) throws FebsException {
        try {
            this.service.pretStartShipmentConfirm(bo);
        } catch (Exception e) {
            message = "生成运输计划失败";
            throw new FebsException(message);
        }
    }
}