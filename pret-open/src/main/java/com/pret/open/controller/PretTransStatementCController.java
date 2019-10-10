package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.service.PretTransStatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransStatementC")
public class PretTransStatementCController extends BaseManageController<PretTransStatementService, PretTransStatement, PretTransStatementVo> {
    @Log("对账确认")
    @PostMapping("/{ids}")
    public void confirmStatement(@PathVariable String ids) throws FebsException {
        try {
            this.service.confirmStatement(ids);
        } catch (Exception e) {
            message = "对账确认失败";
            throw new FebsException(message);
        }
    }
}