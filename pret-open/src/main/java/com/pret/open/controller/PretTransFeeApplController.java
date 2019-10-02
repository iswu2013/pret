package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.service.PretTransFeeService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFee")
public class PretTransFeeController extends BaseManageController<PretTransFeeService, PretTransFee, PretTransFeeVo> {
}