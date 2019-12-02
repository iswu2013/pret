package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretServiceRouteOrigin;
import com.pret.open.entity.bo.PretServiceRouteOrginBo;
import com.pret.open.entity.vo.PretServiceRouteOrginVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.service.PretAddressService;
import com.pret.open.service.PretServiceRouteOriginService;
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
@RequestMapping("pretServiceRouteOrigin")
public class PretServiceRouteOriginController extends BaseManageController<PretServiceRouteOriginService, PretServiceRouteOrigin, PretServiceRouteOrginVo> {
    @Autowired
    private PretAddressRepository pretAddressRepository;
    @Autowired
    private PretAddressService pretAddressService;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretServiceRouteOrginVo request, PretServiceRouteOrigin t) {
        Page<PretServiceRouteOrigin> page = this.service.page(request);
        for (PretServiceRouteOrigin pretServiceRouteOrgin : page.getContent()) {
            if (!StringUtils.isEmpty(pretServiceRouteOrgin.getAddressId())) {
                String address = pretAddressService.getDetailByAddressId(pretServiceRouteOrgin.getAddressId());
                pretServiceRouteOrgin.setFullAddress(address + (pretServiceRouteOrgin.getDetail() == null ? "" :
                        pretServiceRouteOrgin.getDetail()));
            }

        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRouteOrigin view(@PathVariable String id) throws FebsException {
        try {
            PretServiceRouteOrigin item = this.service.findById(id).get();
            if (!StringUtils.isEmpty(item.getAddressId())) {
                PretAddress area = pretAddressRepository.findById(item.getAddressId()).get();
                if (area.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                    item.setNowArea(area.getId());
                } else if (area.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                    item.setNowCity(area.getId());
                } else if (area.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                    item.setNowProvince(area.getId());
                }

                if (!StringUtils.isEmpty(area.getParentId())) {
                    PretAddress city = pretAddressRepository.findById(area.getParentId()).get();
                    if (city.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                        item.setNowArea(city.getId());
                    } else if (city.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                        item.setNowCity(city.getId());
                    } else if (city.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                        item.setNowProvince(city.getId());
                    }

                    if (!StringUtils.isEmpty(city.getParentId())) {
                        PretAddress province = pretAddressRepository.findById(city.getParentId()).get();
                        if (province.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                            item.setNowArea(province.getId());
                        } else if (province.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                            item.setNowCity(province.getId());
                        } else if (province.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                            item.setNowProvince(province.getId());
                        }
                    }
                }

                item.setFullAddress(pretAddressService.getDetailByAddressId(item.getAddressId()) + item.getDetail());
            }
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("新增起运地")
    @PostMapping("/serviceRouteOriginAdd")
    public void serviceRouteOrginAdd(PretServiceRouteOrginBo bo) throws FebsException {
        try {
            this.service.serviceRouteOrginAdd(bo);
        } catch (Exception e) {
            message = "新增起运地失败";
            throw new FebsException(message);
        }
    }
}