package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretFeeType;
import com.pret.open.entity.vo.PretFeeTypeVo;
import com.pret.open.service.PretFeeTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretFeeType")
public class PretFeeTypeController extends BaseManageController<PretFeeTypeService, PretFeeType, PretFeeTypeVo> {
}