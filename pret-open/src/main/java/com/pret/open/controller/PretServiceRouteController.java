package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretBillingIntervalRepository;
import com.pret.open.repository.PretServiceRouteOrginRepository;
import com.pret.open.repository.PretVenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.vo.PretServiceRouteVo;
import com.pret.open.service.PretServiceRouteService;

import java.util.HashMap;
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
                PretServiceRouteOrgin orgin = pretServiceRouteOrginRepository.findById(route.getSeviceRouteOrginId()).get();
                route.setPretServiceRouteOrgin(orgin);
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
}