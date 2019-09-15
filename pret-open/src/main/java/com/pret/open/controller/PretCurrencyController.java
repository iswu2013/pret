package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretCurrency;
import com.pret.open.entity.vo.PretCurrencyVo;
import com.pret.open.service.PretCurrencyService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretCurrency")
public class PretCurrencyController extends BaseManageController<PretCurrencyService, PretCurrency, PretCurrencyVo> {
}