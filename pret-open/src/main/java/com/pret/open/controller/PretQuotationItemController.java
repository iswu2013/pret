package com.pret.open.controller;

import com.google.common.reflect.TypeToken;
import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretQuotationItem;
import com.pret.open.entity.PretUserTableConfig;
import com.pret.open.entity.bo.PretTableItemBo;
import com.pret.open.entity.vo.PretQuotationItemRVo;
import com.pret.open.entity.vo.PretQuotationItemVo;
import com.pret.open.repository.PretQuotationItemRepository;
import com.pret.open.service.PretQuotationItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("pretQuotationItem")
public class PretQuotationItemController extends BaseManageController<PretQuotationItemService, PretQuotationItem, PretQuotationItemVo> {
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretQuotationItem view(@PathVariable String id) throws FebsException {
        try {
            PretQuotationItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @GetMapping(value = "/getByVenderIdAndBillingIntervalId/{venderId}/{billingIntervalId}")
    public List<PretQuotationItemRVo> getByModule(@PathVariable String venderId, @PathVariable String billingIntervalId) {
        List<PretQuotationItemRVo> itemRVoList = new ArrayList<>();

        List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByVenderIdAndS(venderId, ConstantEnum.S.N.getLabel());

        return itemRVoList;
    }
}