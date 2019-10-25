package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretServiceRouteOrginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRouteOrgin")
public class PretServiceRouteOrginController extends BaseManageController<PretServiceRouteOrginService, PretServiceRouteOrgin, PretServiceRouteOrginVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRouteOrgin view(@PathVariable String id) throws FebsException {
        try {
            PretServiceRouteOrgin item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @GetMapping
    @Override()
    public Map<String, Object> list(PretServiceRouteOrginVo request, PretServiceRouteOrgin t) {
        Page<PretServiceRouteOrgin> page = this.service.page(request);
        for (PretServiceRouteOrgin orgin : page.getContent()) {
            if (!StringUtils.isEmpty(orgin.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(orgin.getVenderId()).get();
                orgin.setPretVender(pretVender);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }
}