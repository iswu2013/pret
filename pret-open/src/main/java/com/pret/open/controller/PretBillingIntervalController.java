package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.vo.PretBillingIntervalVo;
import com.pret.open.service.PretBillingIntervalService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretBillingInterval")
public class PretBillingIntervalController extends BaseManageController<PretBillingIntervalService, PretBillingInterval, PretBillingIntervalVo> {
}