package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingIntervalItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Log("查看")
    @PostMapping("/view/{id}")
    public PretCurrency view(@PathVariable String id) throws FebsException {
        try {
            PretCurrency item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}