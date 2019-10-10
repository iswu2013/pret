package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretTransExceptionItem;
import com.pret.open.entity.vo.PretTransExceptionItemVo;
import com.pret.open.service.PretTransExceptionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransExceptionItem")
public class PretTransExceptionItemController extends BaseManageController<PretTransExceptionItemService, PretTransExceptionItem, PretTransExceptionItemVo> {
}