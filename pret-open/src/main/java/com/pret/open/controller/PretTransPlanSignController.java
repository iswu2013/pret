package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.service.PretTransPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransPlanSign")
public class PretTransPlanSignController extends BaseManageController<PretTransPlanService, PretTransPlan, PretTransPlanVo> {

    @Log("签收")
    @PostMapping
    public void add(@Valid PretTransPlan entity) throws FebsException {
        try {
            entity.setStatus();
            this.service.save(t);
        } catch (Exception e) {
            message = "新增失败";
            throw new FebsException(message);
        }
    }
}