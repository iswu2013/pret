package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretVender;
import com.pret.open.entity.vo.PretVenderVo;
import com.pret.open.service.PretVenderService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretVender")
public class PretVenderController extends BaseManageController<PretVenderService, PretVender, PretVenderVo> {
}