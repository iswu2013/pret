package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.service.PretServiceRouteOrginService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRouteOrgin")
public class PretServiceRouteOrginController extends BaseManageController<PretServiceRouteOrginService, PretServiceRouteOrgin, PretServiceRouteOrginVo> {
}