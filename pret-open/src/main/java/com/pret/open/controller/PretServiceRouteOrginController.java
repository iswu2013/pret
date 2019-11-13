package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.exception.FebsException;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretPickUpAddress;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.PretServiceRouteOrginBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.repository.PretPickUpAddressRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretServiceRouteOrginService;
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

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRouteOrgin")
public class PretServiceRouteOrginController extends BaseManageController<PretServiceRouteOrginService, PretServiceRouteOrgin, PretServiceRouteOrginVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretPickUpAddressRepository pretPickUpAddressRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRouteOrgin view(@PathVariable String id) throws FebsException {
        try {
            PretServiceRouteOrgin item = this.service.findById(id).get();
            if (!StringUtils.isEmpty(item.getAddressId())) {
                PretAddress area = pretAddressRepository.findById(item.getAddressId()).get();
                item.setNowArea(area.getId());
                PretAddress city = pretAddressRepository.findById(area.getParentId()).get();
                item.setNowCity(city.getId());
                PretAddress province = pretAddressRepository.findById(city.getParentId()).get();
                item.setNowProvince(province.getId());
                item.setFullAddress(province.getName() + city.getName() + area.getName() + item.getDetail());
            }
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
        for (PretServiceRouteOrgin pretServiceRouteOrgin : page.getContent()) {
            if (!StringUtils.isEmpty(pretServiceRouteOrgin.getAddressId())) {
                PretAddress area = pretAddressRepository.findById(pretServiceRouteOrgin.getAddressId()).get();
                PretAddress city = pretAddressRepository.findById(area.getParentId()).get();
                PretAddress province = pretAddressRepository.findById(city.getParentId()).get();

                pretServiceRouteOrgin.setFullAddress(province.getName() + city.getName() + area.getName() + pretServiceRouteOrgin.getDetail());
            }

        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("新增起运地")
    @PostMapping("/serviceRouteOrginAdd")
    public void serviceRouteOrginAdd(PretServiceRouteOrginBo bo) throws FebsException {
        try {
            this.service.serviceRouteOrginAdd(bo);
        } catch (Exception e) {
            message = "新增起运地失败";
            throw new FebsException(message);
        }
    }
}