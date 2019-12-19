package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretSales;
import com.pret.open.entity.vo.PretCustomerVo;
import com.pret.open.entity.vo.PretDriverVo;
import com.pret.open.entity.vo.PretSalesVo;
import com.pret.open.service.PretDriverService;
import com.pret.open.service.PretSalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretSales")
public class PretSalesController extends BaseManageController<PretSalesService, PretSales, PretSalesVo> {

    @GetMapping
    @Override()
    public Map<String, Object> list(PretSalesVo request, PretSales t) {
        Page<PretSales> page = this.service.page(request);
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

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