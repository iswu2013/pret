package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretGoods;
import com.pret.open.entity.vo.PretGoodsVo;
import com.pret.open.service.PretGoodsService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretGoods")
public class PretGoodsController extends BaseManageController<PretGoodsService, PretGoods, PretGoodsVo> {
}