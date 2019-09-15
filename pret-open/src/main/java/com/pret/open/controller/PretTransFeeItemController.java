package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransFeeItem;
import com.pret.open.entity.vo.PretTransFeeItemVo;
import com.pret.open.service.PretTransFeeItemService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFeeItem")
public class PretTransFeeItemController extends BaseManageController<PretTransFeeItemService, PretTransFeeItem, PretTransFeeItemVo> {
}