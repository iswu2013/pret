package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.service.PretTransPlanService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransPlanSign")
public class PretTransPlanSignController extends BaseManageController<PretTransPlanService, PretTransPlan, PretTransPlanVo> {
}