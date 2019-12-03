package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.util.SortConditionUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretTransOrderGroupVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretServiceRouteOriginRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretTransOrderGroupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransOrderGroup")
public class PretTransOrderGroupController extends BaseManageController<PretTransOrderGroupService, PretTransOrderGroup, PretTransOrderGroupVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransOrderGroupVo request, PretTransOrderGroup t) {
        request.setSortConditions(SortConditionUtil.build("desc", "lastModifiedDate"));
        Page<PretTransOrderGroup> page = this.service.page(request);
        for (PretTransOrderGroup route : page.getContent()) {
            if (!StringUtils.isEmpty(route.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(route.getVenderId()).get();
                route.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(route.getCustomerId())) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(route.getCustomerId()).get();
                route.setPretCustomer(pretCustomer);
            }
            if (!StringUtils.isEmpty(route.getServiceRouteOriginId())) {
                PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(route.getServiceRouteOriginId()).get();
                route.setPretServiceRouteOrigin(pretServiceRouteOrigin);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }
}