package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
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
}