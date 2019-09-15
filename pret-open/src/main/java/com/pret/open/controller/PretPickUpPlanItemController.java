package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretPickUpPlanItem;
import com.pret.open.entity.vo.PretPickUpPlanItemVo;
import com.pret.open.service.PretPickUpPlanItemService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpPlanItem")
public class PretPickUpPlanItemController extends BaseManageController<PretPickUpPlanItemService, PretPickUpPlanItem, PretPickUpPlanItemVo> {
}