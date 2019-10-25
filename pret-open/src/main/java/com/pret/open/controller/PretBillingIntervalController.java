package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.repository.PretVenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.vo.PretBillingIntervalVo;
import com.pret.open.service.PretBillingIntervalService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretBillingInterval")
public class PretBillingIntervalController extends BaseManageController<PretBillingIntervalService, PretBillingInterval, PretBillingIntervalVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretBillingIntervalVo request, PretBillingInterval t) {
        Page<PretBillingInterval> page = this.service.page(request);
        for (PretBillingInterval interval : page.getContent()) {
            if (!StringUtils.isEmpty(interval.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(interval.getVenderId()).get();
                interval.setPretVender(pretVender);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretBillingInterval view(@PathVariable String id) throws FebsException {
        try {
            PretBillingInterval item = this.service.findById(id).get();
            List<PretBillingIntervalItem> list = pretBillingIntervalItemRepository.findByBillingIntervalId(item.getId());
            item.setPretBillingIntervalItemList(list);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}