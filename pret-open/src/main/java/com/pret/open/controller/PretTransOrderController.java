package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.service.PretTransOrderService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransOrder")
public class PretTransOrderController extends BaseManageController<PretTransOrderService, PretTransOrder, PretTransOrderVo> {
}