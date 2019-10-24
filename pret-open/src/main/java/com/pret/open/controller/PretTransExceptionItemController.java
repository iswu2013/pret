package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransException;
import com.pret.open.entity.PretTransExceptionItem;
import com.pret.open.entity.vo.PretTransExceptionItemVo;
import com.pret.open.service.PretTransExceptionItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransExceptionItem")
public class PretTransExceptionItemController extends BaseManageController<PretTransExceptionItemService, PretTransExceptionItem, PretTransExceptionItemVo> {
    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransExceptionItem view(@PathVariable String id) throws FebsException {
        try {
            PretTransExceptionItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}