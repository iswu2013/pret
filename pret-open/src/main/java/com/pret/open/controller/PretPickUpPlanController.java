package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.service.PretPickUpPlanService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpPlan")
public class PretPickUpPlanController extends BaseManageController<PretPickUpPlanService, PretPickUpPlan, PretPickUpPlanVo> {
}