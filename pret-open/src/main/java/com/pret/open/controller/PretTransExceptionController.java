package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransExceptionBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretTransException;
import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.service.PretTransExceptionService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransException")
public class PretTransExceptionController extends BaseManageController<PretTransExceptionService, PretTransException, PretTransExceptionVo> {
    @Log("生成异常单")
    @PostMapping("/genPretTransException")
    public void genPretTransException(PretTransExceptionBo bo) throws FebsException {
        try {
            this.service.genPretTransException(bo);
        } catch (Exception e) {
            message = "生成异常单失败";
            throw new FebsException(message);
        }
    }
}