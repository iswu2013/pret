package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.vo.PretBillingIntervalItemVo;
import com.pret.open.service.PretBillingIntervalItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretBillingIntervalItem")
public class PretBillingIntervalItemController extends BaseManageController<PretBillingIntervalItemService, PretBillingIntervalItem, PretBillingIntervalItemVo> {

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretBillingIntervalItem view(@PathVariable String id) throws FebsException {
        try {
            PretBillingIntervalItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}