package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.PretServiceRouteItem;
import com.pret.open.entity.PretVender;
import com.pret.open.entity.bo.AreaBo;
import com.pret.open.entity.bo.PretServiceRouteBo;
import com.pret.open.entity.vo.PretServiceRouteItemVo;
import com.pret.open.entity.vo.PretServiceRouteVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.repository.PretServiceRouteRepository;
import com.pret.open.service.PretServiceRouteService;
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
@RequestMapping("pretServiceRoute")
public class PretServiceRouteController extends BaseManageController<PretServiceRouteService, PretServiceRoute, PretServiceRouteVo> {
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;
    @Autowired
    private PretServiceRouteRepository pretServiceRouteRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretServiceRouteVo request, PretServiceRoute t) {
        Page<PretServiceRoute> page = this.service.page(request);
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRoute view(@PathVariable String id) throws FebsException {
        try {
            List<AreaBo> list = new ArrayList<>();

            PretServiceRoute item = this.service.findById(id).get();
            List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByServiceRouteIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            if (serviceRouteItemList != null && serviceRouteItemList.size() > 0) {
                for (PretServiceRouteItem it : serviceRouteItemList) {
                    AreaBo areaBo = new AreaBo();
                    if (!StringUtils.isEmpty(it.getAddressId())) {
                        PretAddress pretAddress = pretAddressRepository.findById(it.getAddressId()).get();
                        if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                            areaBo.setArea(pretAddress.getName());
                            PretAddress city = pretAddressRepository.findById(pretAddress.getParentId()).get();
                            areaBo.setCity(city.getName());
                            PretAddress province = pretAddressRepository.findById(city.getParentId()).get();
                            areaBo.setProvince(province.getName());
                        } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                            areaBo.setCity(pretAddress.getName());
                            PretAddress province = pretAddressRepository.findById(pretAddress.getParentId()).get();
                            areaBo.setProvince(province.getName());
                        } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.省.getLabel()) {
                            areaBo.setProvince(pretAddress.getName());
                        }
                        areaBo.setLabel(pretAddress.getName());
                        areaBo.setValue(pretAddress.getId());
                        areaBo.setServiceRouteOriginId(it.getServiceRouteOriginId());
                        areaBo.setPrescription(it.getPrescription());
                        list.add(areaBo);
                    }
                }
            }
            item.setAreaBoList(list);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @GetMapping(value = "/getByVenderIdOrVenderIdIsNull/{venderId}")
    public List<PretServiceRoute> getByVenderIdOrVenderIdIsNull(@PathVariable String venderId) {
        return pretServiceRouteRepository.findByVenderIdOrVenderIdIsNull(venderId);
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
            this.service.pretServiceRouteEdit(bo);
        } catch (Exception e) {
            message = "编辑服务线路";
            throw new FebsException(message);
        }
    }
}