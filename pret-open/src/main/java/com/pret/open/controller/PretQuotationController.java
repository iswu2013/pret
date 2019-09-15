package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretQuotation;
import com.pret.open.entity.vo.PretQuotationVo;
import com.pret.open.service.PretQuotationService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretQuotation")
public class PretQuotationController extends BaseManageController<PretQuotationService, PretQuotation, PretQuotationVo> {
}