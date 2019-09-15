package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretDriver;
import com.pret.open.entity.vo.PretDriverVo;
import com.pret.open.service.PretDriverService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretDriver")
public class PretDriverController extends BaseManageController<PretDriverService, PretDriver, PretDriverVo> {
}