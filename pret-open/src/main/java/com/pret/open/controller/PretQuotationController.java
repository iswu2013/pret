package com.pret.open.controller;

import com.google.common.base.Joiner;
import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretQuotationBo;
import com.pret.open.entity.vo.PretQuotationVo;
import com.pret.open.repository.PretQuotationItemRepository;
import com.pret.open.repository.PretServiceRouteRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretQuotationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private PretServiceRouteRepository pretServiceRouteRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretQuotationVo request, PretQuotation t) {
        Page<PretQuotation> page = this.service.page(request);
        for (PretQuotation pretQuotation : page.getContent()) {
            if (!StringUtils.isEmpty(pretQuotation.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretQuotation.getVenderId()).get();
                pretQuotation.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(pretQuotation.getServiceRouteId())) {
                if (pretQuotation.getServiceRouteId().contains(",")) {
                    List<String> nameList = new ArrayList<>();

                    List<String> idList = StringUtil.idsStr2ListString(pretQuotation.getServiceRouteId());
                    for (String id : idList) {
                        PretServiceRoute pretServiceRoute = this.pretServiceRouteRepository.findById(id).get();
                        nameList.add(pretServiceRoute.getName());
                    }
                    pretQuotation.setServiceRouteNames(Joiner.on(",").join(nameList));
                } else {
                    PretServiceRoute pretServiceRoute = pretServiceRouteRepository.findById(pretQuotation.getServiceRouteId()).get();
                    pretQuotation.setPretServiceRoute(pretServiceRoute);
                    pretQuotation.setServiceRouteNames(pretServiceRoute.getName());
                }
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

    @Log("生成报价")
    @PostMapping("/pretQuotationAdd")
    public void pretQuotationAdd(PretQuotationBo bo) throws FebsException {
        try {
            this.service.pretQuotationAdd(bo);
        } catch (Exception e) {
            message = "生成报价失败";
            throw new FebsException(message);
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