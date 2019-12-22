package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.SortConditionUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretTransOrderGroupVo;
import com.pret.open.repository.*;
import com.pret.open.service.PretTransOrderGroupService;
import com.pret.open.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransOrderGroupVo request, PretTransOrderGroup t) {
        request.setSortConditions(SortConditionUtil.build("desc", "lastModifiedDate"));
        if (!StringUtils.isEmpty(request.getUserId())) {
            request.setIn$deptId(userService.getDeptIdListByUserId(request.getUserId()));
        }

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
            route.setTotalGw(pretTransOrderRepository.sumKiloByTransOrderGroupId(route.getId()));
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransOrderGroup view(@PathVariable String id) throws FebsException {
        try {
            PretTransOrderGroup item = this.service.findById(id).get();
            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransOrderGroupIdAndS(item.getId(), ConstantEnum.S.N.getLabel());
            item.setPretTransOrderList(pretTransOrderList);
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("退回")
    @PostMapping("/return/{ids}")
    public void auth(@PathVariable String ids) throws FebsException {
        try {
            List<String> idList = StringUtil.idsStr2ListString(ids);
            for (String id : idList) {
                PretTransOrderGroup pretTransOrderGroup = this.service.findById(id).get();
                pretTransOrderGroup.setReturnFlag(ConstantEnum.YesOrNo.是.getLabel());
                pretTransOrderGroup.setVenderId(null);
                pretTransOrderGroup.setStatus(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                pretTransOrderGroupRepository.save(pretTransOrderGroup);

                List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransOrderGroupIdAndS(id, ConstantEnum.S.N.getLabel());
                for (PretTransOrder pretTransOrder : pretTransOrderList) {
                    pretTransOrder.setVenderId(null);
                    pretTransOrder.setReturnFlag(ConstantEnum.YesOrNo.是.getLabel());
                    pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                }
                pretTransOrderRepository.saveAll(pretTransOrderList);
            }
        } catch (Exception e) {
            message = "审核失败";
            throw new FebsException(message);
        }
    }
}