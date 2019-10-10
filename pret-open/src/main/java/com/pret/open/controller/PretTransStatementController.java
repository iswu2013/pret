package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransStatementBo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.pret.open.entity.PretTransStatement;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.service.PretTransStatementService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransStatement")
public class PretTransStatementController extends BaseManageController<PretTransStatementService, PretTransStatement, PretTransStatementVo> {

    @Log("生成对账作业")
    @PostMapping("/genTransStatement")
    public void genTransStatement(PretTransStatementBo bo) throws FebsException {
        try {
            this.service.genTransStatement(bo);
        } catch (Exception e) {
            message = "生成对账作业失败";
            throw new FebsException(message);
        }
    }

    @InitBinder
    protected void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }
}