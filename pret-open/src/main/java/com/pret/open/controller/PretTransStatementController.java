package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.service.PretTransStatementService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransStatement")
public class PretTransStatementController extends BaseManageController<PretTransStatementService, PretTransStatement, PretTransStatementVo> {
}