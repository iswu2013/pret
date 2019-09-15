package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretCustomerAddress;
import com.pret.open.entity.vo.PretCustomerAddressVo;
import com.pret.open.service.PretCustomerAddressService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretCustomerAddress")
public class PretCustomerAddressController extends BaseManageController<PretCustomerAddressService, PretCustomerAddress, PretCustomerAddressVo> {
}