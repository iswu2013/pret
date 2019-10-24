package com.pret.open.controller;

import com.google.common.base.Joiner;
import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretAddressBo;
import com.pret.open.entity.bo.PretServiceRouteBo;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretBillingIntervalRepository;
import com.pret.open.repository.PretServiceRouteOrginRepository;
import com.pret.open.repository.PretVenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pret.open.entity.vo.PretServiceRouteVo;
import com.pret.open.service.PretServiceRouteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRoute")
public class PretServiceRouteController extends BaseManageController<PretServiceRouteService, PretServiceRoute, PretServiceRouteVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretBillingIntervalRepository pretBillingIntervalRepository;
    @Autowired
    private PretServiceRouteOrginRepository pretServiceRouteOrginRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRoute view(@PathVariable String id) throws FebsException {
        try {
            PretServiceRoute item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @GetMapping
    @Override()
    public Map<String, Object> list(PretServiceRouteVo request, PretServiceRoute t) {
        Page<PretServiceRoute> page = this.service.page(request);
        for (PretServiceRoute route : page.getContent()) {
            if (!StringUtils.isEmpty(route.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(route.getVenderId()).get();
                route.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(route.getSeviceRouteOrginId())) {
                if (route.getSeviceRouteOrginId().contains(",")) {
                    List<String> nameList = new ArrayList<>();
                    List<String> idList = StringUtil.idsStr2ListString(route.getSeviceRouteOrginId());
                    List<PretServiceRouteOrgin> pretServiceRouteOrginList = pretServiceRouteOrginRepository.findByIdIn(idList);
                    for (PretServiceRouteOrgin pretServiceRoute : pretServiceRouteOrginList) {
                        nameList.add(pretServiceRoute.getName());
                    }
                    route.setSeviceRouteOrginName(Joiner.on(",").join(nameList));
                } else {
                    PretServiceRouteOrgin orgin = pretServiceRouteOrginRepository.findById(route.getSeviceRouteOrginId()).get();
                    route.setSeviceRouteOrginName(orgin.getName());
                }
            }
            if (!StringUtils.isEmpty(route.getBillingIntervalId())) {
                PretBillingInterval interval = pretBillingIntervalRepository.findById(route.getBillingIntervalId()).get();
                route.setPretBillingInterval(interval);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("生成服务线路")
    @PostMapping("/pretServiceRouteAdd")
    public void pretServiceRouteAdd(PretServiceRouteBo bo) throws FebsException {
        try {
            this.service.pretServiceRouteAdd(bo);
        } catch (Exception e) {
            message = "生成服务线路失败";
            throw new FebsException(message);
        }
    }

    @Log("编辑服务线路")
    @PostMapping("/pretServiceRouteEdit")
    public void pretServiceRouteEdit(PretServiceRouteBo bo) throws FebsException {
        try {
            this.service.pretServiceRouteAdd(bo);
        } catch (Exception e) {
            message = "编辑服务线路";
            throw new FebsException(message);
        }
    }
}