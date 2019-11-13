package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.bo.PretBillingIntervalBo;
import com.pret.open.entity.vo.PretBillingIntervalVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.service.PretBillingIntervalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretBillingInterval")
public class PretBillingIntervalController extends BaseManageController<PretBillingIntervalService, PretBillingInterval, PretBillingIntervalVo> {
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretBillingIntervalVo request, PretBillingInterval t) {
        Page<PretBillingInterval> page = this.service.page(request);
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
            List<PretBillingIntervalItem> list = pretBillingIntervalItemRepository.findByBillingIntervalIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            item.setPretBillingIntervalItemList(list);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("生成计费区间")
    @PostMapping("/pretBillingIntervalAdd")
    public void pretBillingIntervalAdd(PretBillingIntervalBo bo) throws FebsException {
        try {
            this.service.pretBillingIntervalAdd(bo);
        } catch (Exception e) {
            message = "生成计费区间失败";
            throw new FebsException(message);
        }
    }

    @Log("编辑计费区间")
    @PostMapping("/pretBillingIntervalEdit")
    public void pretBillingIntervalEdit(PretBillingIntervalBo bo) throws FebsException {
        try {
            this.service.pretBillingIntervalEdit(bo);
        } catch (Exception e) {
            message = "编辑计费区间失败";
            throw new FebsException(message);
        }
    }
}