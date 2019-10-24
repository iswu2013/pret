package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretQuotationItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretQuotationItemPrice;
import com.pret.open.entity.vo.PretQuotationItemPriceVo;
import com.pret.open.service.PretQuotationItemPriceService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretQuotationItemPrice")
public class PretQuotationItemPriceController extends BaseManageController<PretQuotationItemPriceService, PretQuotationItemPrice, PretQuotationItemPriceVo> {

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretQuotationItemPrice view(@PathVariable String id) throws FebsException {
        try {
            PretQuotationItemPrice item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}