package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.vo.PretCustomerVo;
import com.pret.open.service.PretCustomerService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretCustomer")
public class PretCustomerController extends BaseManageController<PretCustomerService, PretCustomer, PretCustomerVo> {
}