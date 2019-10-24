package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretPickUpAddress;
import com.pret.open.entity.vo.PretPickUpAddressVo;
import com.pret.open.service.PretPickUpAddressService;

@Slf4j
@Validated
@RestController
@RequestMapping("pretPickUpAddress")
public class PretPickUpAddressController extends BaseManageController<PretPickUpAddressService, PretPickUpAddress, PretPickUpAddressVo> {

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretPickUpAddress view(@PathVariable String id) throws FebsException {
        try {
            PretPickUpAddress item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}