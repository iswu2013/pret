package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretTransOrderStatistics;
import com.pret.open.entity.vo.PretTransOrderStatisticsVo;
import com.pret.open.service.PretTransOrderStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransOrderStatistics")
public class PretTransOrderStatisticsController extends BaseManageController<PretTransOrderStatisticsService, PretTransOrderStatistics, PretTransOrderStatisticsVo> {
}