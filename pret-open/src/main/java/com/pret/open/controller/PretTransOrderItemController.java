package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransOrderItem;
import com.pret.open.entity.vo.PretTransOrderItemVo;
import com.pret.open.service.PretTransOrderItemService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransOrderItem")
public class PretTransOrderItemController extends BaseManageController<PretTransOrderItemService, PretTransOrderItem, PretTransOrderItemVo> {
}