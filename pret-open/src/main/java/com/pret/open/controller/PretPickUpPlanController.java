package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretPickUpPlanModifyDriverBo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretServiceRouteOriginRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretPickUpPlanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpPlan")
public class PretPickUpPlanController extends BaseManageController<PretPickUpPlanService, PretPickUpPlan, PretPickUpPlanVo> {
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretDriverRepository pretDriverRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretPickUpPlanVo request, PretPickUpPlan t) {
        Page<PretPickUpPlan> page = this.service.page(request);
        for (PretPickUpPlan pickUpPlan : page.getContent()) {
            List<PretTransOrder> transOrderList = pretTransOrderRepository.findByPickUpPlanIdAndS(pickUpPlan.getId(), ConstantEnum.S.N.getLabel());
            pickUpPlan.setTransOrderList(transOrderList);
            if (!StringUtils.isEmpty(pickUpPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pickUpPlan.getVenderId()).get();
                pickUpPlan.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(pickUpPlan.getDriverId())) {
                PretDriver pretDriver = pretDriverRepository.findById(pickUpPlan.getDriverId()).get();
                pickUpPlan.setPretDriver(pretDriver);
            }
            if (!StringUtils.isEmpty(pickUpPlan.getServiceRouteOriginId())) {
                PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(pickUpPlan.getServiceRouteOriginId()).get();
                pickUpPlan.setPretServiceRouteOrigin(pretServiceRouteOrigin);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretPickUpPlan view(@PathVariable String id) throws FebsException {
        try {
            PretPickUpPlan item = this.service.findById(id).get();
            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransPlanIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            item.setTransOrderList(pretTransOrderList);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("生成提货计划")
    @PostMapping("/pretPickUpPlanAdd")
    public void pretPickUpPlanAdd(PretPickUpPlanBo bo) throws FebsException {
        try {
            this.service.genPickUpPlan(bo);
        } catch (Exception e) {
            message = "生成提货失败";
            throw new FebsException(message);
        }
    }

    @Log("取消提货计划")
    @PostMapping("/pretPickUpPlanCancel/{ids}")
    public void pretPickUpPlanCancel(@PathVariable String ids) throws FebsException {
        try {
            this.service.pretPickUpPlanCancel(ids);
        } catch (Exception e) {
            message = "删除失败";
            throw new FebsException(message);
        }
    }

    @Log("修改提货司机")
    @PostMapping("/pretModifyDriver")
    public void pretModifyDriver(PretPickUpPlanModifyDriverBo bo) throws FebsException {
        try {
            this.service.pretModifyDriver(bo);
        } catch (Exception e) {
            message = "修改司机失败";
            throw new FebsException(message);
        }
    }
}