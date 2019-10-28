package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.api.vo.LabelValue;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.msg.ListRestResponse;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.vo.PretBillingIntervalItemVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.service.PretBillingIntervalItemService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("pretBillingIntervalItem")
public class PretBillingIntervalItemController extends BaseManageController<PretBillingIntervalItemService, PretBillingIntervalItem, PretBillingIntervalItemVo> {
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;

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

    /* *
     * 功能描述: 根据billingIntervalId查找
     * 〈〉
     * @Param: [billingIntervalId]
     * @Return: java.util.List<com.pret.open.entity.PretBillingIntervalItem>
     * @Author: wujingsong
     * @Date: 2019/10/28  11:41 下午
     */
    @RequestMapping(value = "/getByBillingInterval/{billingIntervalId}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretBillingIntervalItem> getByBillingInterval(@PathVariable String billingIntervalId) {
        List<PretBillingIntervalItem> pretBillingIntervalItemList = pretBillingIntervalItemRepository.findByBillingIntervalId(billingIntervalId);
        return pretBillingIntervalItemList;
    }
}