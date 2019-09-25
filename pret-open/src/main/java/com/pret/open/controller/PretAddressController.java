package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretAddress;
import com.pret.open.entity.vo.PretAddressVo;
import com.pret.open.service.PretAddressService;

/**
 * 地址管理
 */
@Slf4j
@Validated
@RestController
@RequestMapping("pretAddress")
public class PretAddressController extends BaseManageController<PretAddressService, PretAddress, PretAddressVo> {
}