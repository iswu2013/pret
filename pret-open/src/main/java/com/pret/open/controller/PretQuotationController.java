package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretQuotation;
import com.pret.open.entity.PretQuotationItem;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.PretQuotationBo;
import com.pret.open.entity.vo.PretQuotationVo;
import com.pret.open.repository.PretBillingIntervalRepository;
import com.pret.open.repository.PretQuotationItemRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretQuotationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/* *
 * 功能描述: 报价
 * 〈〉
 * @Param:
 * @Return:
 * @Author: wujingsong
 * @Date: 2019/10/25  3:18 下午
 */
@Slf4j
@Validated
@RestController
@RequestMapping("pretQuotation")
public class PretQuotationController extends BaseManageController<PretQuotationService, PretQuotation, PretQuotationVo> {
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretBillingIntervalRepository pretBillingIntervalRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretQuotationVo request, PretQuotation t) {
        Page<PretQuotation> page = this.service.page(request);
        for (PretQuotation pretQuotation : page.getContent()) {
            if (!StringUtils.isEmpty(pretQuotation.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretQuotation.getVenderId()).get();
                pretQuotation.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(pretQuotation.getBillingIntervalId())) {
                PretBillingInterval pretBillingInterval = pretBillingIntervalRepository.findById(pretQuotation.getBillingIntervalId()).get();
                pretQuotation.setPretBillingInterval(pretBillingInterval);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretQuotation view(@PathVariable String id) throws FebsException {
        try {
            PretQuotation item = this.service.findById(id).get();
            List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByQuotationId(item.getId());
            item.setPretQuotationItemList(pretQuotationItemList);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("删除")
    @DeleteMapping("/delete/{ids}")
    public void deleteByIds(@PathVariable String ids) throws FebsException {
        try {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                this.service.lDelete(id);
                List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByQuotationId(id);
                for (PretQuotationItem pretQuotationItem : pretQuotationItemList) {
                    pretQuotationItem.setS(ConstantEnum.S.D.getLabel());
                }
                pretQuotationItemRepository.saveAll(pretQuotationItemList);
            }
        } catch (Exception e) {
            message = "删除失败";
            throw new FebsException(message);
        }
    }

    @Log("生成报价")
    @PostMapping("/pretQuotationAdd")
    public void pretQuotationAdd(PretQuotationBo bo) throws FebsException {
        try {
            this.service.pretQuotationAdd(bo);
        } catch (Exception e) {
            System.out.println("e" + e.getMessage());
            throw new FebsException(e.getMessage());
        }
    }

    @Log("编辑报价")
    @PostMapping("/pretQuotationEdit")
    public void pretQuotationEdit(PretQuotationBo bo) throws FebsException {
        try {
            this.service.pretQuotationEdit(bo);
        } catch (Exception e) {
            System.out.println("e" + e.getMessage());
            throw new FebsException(e.getMessage());
        }
    }

    @Log("报价审核")
    @PostMapping("/check/{userId}/{id}/{status}")
    public void check(@PathVariable String userId, @PathVariable String id, @PathVariable int status) throws FebsException {
        try {
            this.service.check(userId, id, status);
        } catch (Exception e) {
            message = "报价审核";
            throw new FebsException(message);
        }
    }
}