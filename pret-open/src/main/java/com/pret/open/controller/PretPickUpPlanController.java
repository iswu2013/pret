package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretBillingIntervalVo;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretVenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.service.PretPickUpPlanService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpPlan")
public class PretPickUpPlanController extends BaseManageController<PretPickUpPlanService, PretPickUpPlan, PretPickUpPlanVo> {
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretPickUpPlanVo request, PretPickUpPlan t) {
        Page<PretPickUpPlan> page = this.service.page(request);
        for (PretPickUpPlan pickUpPlan : page.getContent()) {
            List<PretTransOrder> transOrderList  = transOrderRepository.findByPickUpPlanId(pickUpPlan.getId());
            pickUpPlan.setTransOrderList(transOrderList);
            if(!StringUtils.isEmpty(pickUpPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pickUpPlan.getVenderId()).get();
                pickUpPlan.setPretVender(pretVender);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("生成提货计划")
    @PostMapping("/pretPickUpPlanAdd")
    public void pretPickUpPlanAdd(PretPickUpPlanBo bo) throws FebsException {
        try {
            this.service.genPickUpPlan(bo);
        } catch (Exception e) {
            message = "删除失败";
            throw new FebsException(message);
        }
    }
}