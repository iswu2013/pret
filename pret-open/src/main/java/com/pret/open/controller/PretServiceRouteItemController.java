package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.PretServiceRouteItem;
import com.pret.open.entity.PretServiceRouteOrgin;
import com.pret.open.entity.vo.PretServiceRouteItemVo;
import com.pret.open.entity.vo.PretServiceRouteVo;
import com.pret.open.repository.PretAddressRepository;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.repository.PretServiceRouteOrginRepository;
import com.pret.open.service.PretServiceRouteItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretServiceRouteItem")
public class PretServiceRouteItemController extends BaseManageController<PretServiceRouteItemService, PretServiceRouteItem, PretServiceRouteItemVo> {
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;
    @Autowired
    private PretServiceRouteOrginRepository pretServiceRouteOrginRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretServiceRouteItem view(@PathVariable String id) throws FebsException {
        try {
            PretServiceRouteItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 根据serviceLineId查找
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/10/24  9:33 上午
     */
    @GetMapping(value = "/getByServiceLineId/{id}")
    public List<PretServiceRouteItem> getByServiceLineId(@PathVariable String id) {
        List<PretServiceRouteItem> serviceRouteItemList = pretServiceRouteItemRepository.findByServiceLineId(id);

        return serviceRouteItemList;
    }

    @GetMapping
    @Override()
    public Map<String, Object> list(PretServiceRouteItemVo request, PretServiceRouteItem t) {
        Page<PretServiceRouteItem> page = this.service.page(request);
        for (PretServiceRouteItem route : page.getContent()) {
            String startEndName = StringUtils.EMPTY;
            PretServiceRouteOrgin pretServiceRouteOrgin = pretServiceRouteOrginRepository.findById(route.getServiceRouteOrginId()).get();
            startEndName += pretServiceRouteOrgin.getName() + "-";
            PretAddress pretAddress = pretAddressRepository.findById(route.getAddressId()).get();
            if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.区县.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                PretAddress a = pretAddressRepository.findById(address.getParentId()).get();
                startEndName += a.getName() + address.getName() + pretAddress.getName();
            } else if (pretAddress.getLevels() == ConstantEnum.AreaLevelEnum.市.getLabel()) {
                PretAddress address = pretAddressRepository.findById(pretAddress.getParentId()).get();
                startEndName += address.getName() + pretAddress.getName();
            } else {
                startEndName += pretAddress.getName();
            }
            route.setStartEndName(startEndName);
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }
}