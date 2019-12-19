package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretSales;
import com.pret.open.entity.vo.PretDriverVo;
import com.pret.open.entity.vo.PretSalesVo;
import com.pret.open.service.PretDriverService;
import com.pret.open.service.PretSalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretSales")
public class PretSalesController extends BaseManageController<PretSalesService, PretSales, PretSalesVo> {

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretSales view(@PathVariable String id) throws FebsException {
        try {
            PretSales item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}