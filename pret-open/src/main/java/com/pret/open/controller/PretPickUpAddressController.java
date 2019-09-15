package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretPickUpAddress;
import com.pret.open.entity.vo.PretPickUpAddressVo;
import com.pret.open.service.PretPickUpAddressService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpAddress")
public class PretPickUpAddressController extends BaseManageController<PretPickUpAddressService, PretPickUpAddress, PretPickUpAddressVo> {
}