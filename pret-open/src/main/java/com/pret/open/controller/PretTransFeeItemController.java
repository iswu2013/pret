package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretTransFeeItem;
import com.pret.open.entity.vo.PretTransFeeItemVo;
import com.pret.open.service.PretTransFeeItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransFeeItem")
public class PretTransFeeItemController extends BaseManageController<PretTransFeeItemService, PretTransFeeItem, PretTransFeeItemVo> {

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransFeeItem view(@PathVariable String id) throws FebsException {
        try {
            PretTransFeeItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}