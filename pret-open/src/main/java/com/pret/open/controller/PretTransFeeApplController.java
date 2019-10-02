package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.service.PretTransFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFeeAppl")
public class PretTransFeeApplController extends BaseManageController<PretTransFeeService, PretTransFee, PretTransFeeVo> {
}