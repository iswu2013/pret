package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.bo.PretQuotationBo;
import com.pret.open.entity.bo.PretServiceRouteBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Log("生成报价")
    @PostMapping("/pretQuotationAdd")
    public void pretQuotationAdd(PretQuotationBo bo) throws FebsException {
        try {
            this.service.pretQuotationAdd(bo);
        } catch (Exception e) {
            message = "生成服务线路失败";
            throw new FebsException(message);
        }
    }
}