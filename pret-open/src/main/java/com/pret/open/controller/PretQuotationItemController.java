package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretQuotationItem;
import com.pret.open.entity.vo.PretQuotationItemVo;
import com.pret.open.service.PretQuotationItemService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretQuotationItem")
public class PretQuotationItemController extends BaseManageController<PretQuotationItemService, PretQuotationItem, PretQuotationItemVo> {
}