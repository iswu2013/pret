package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransTrajectory;
import com.pret.open.entity.vo.PretTransTrajectoryVo;
import com.pret.open.service.PretTransTrajectoryService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransTrajectory")
public class PretTransTrajectoryController extends BaseManageController<PretTransTrajectoryService, PretTransTrajectory, PretTransTrajectoryVo> {
}