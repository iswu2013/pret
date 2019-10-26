package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransTrajectory;
import com.pret.open.entity.vo.PretTransTrajectoryVo;
import com.pret.open.service.PretTransTrajectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransTrajectory")
public class PretTransTrajectoryController extends BaseManageController<PretTransTrajectoryService, PretTransTrajectory, PretTransTrajectoryVo> {

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransTrajectory view(@PathVariable String id) throws FebsException {
        try {
            PretTransTrajectory item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}