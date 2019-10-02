package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.service.PretTransStatementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransStatementC")
public class PretTransStatementCController extends BaseManageController<PretTransStatementService, PretTransStatement, PretTransStatementVo> {
}