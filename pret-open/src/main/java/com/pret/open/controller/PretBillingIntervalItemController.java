package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.api.vo.LabelValue;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.msg.ListRestResponse;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretBillingIntervalItemVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.repository.PretServiceRouteRepository;
import com.pret.open.service.PretBillingIntervalItemService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequestMapping("pretBillingIntervalItem")
public class PretBillingIntervalItemController extends BaseManageController<PretBillingIntervalItemService, PretBillingIntervalItem, PretBillingIntervalItemVo> {
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;
    @Autowired
    private PretServiceRouteRepository pretServiceRouteRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretBillingIntervalItem view(@PathVariable String id) throws FebsException {
        try {
            PretBillingIntervalItem item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 根据billingIntervalId查找
     * 〈〉
     * @Param: [billingIntervalId]
     * @Return: java.util.List<com.pret.open.entity.PretBillingIntervalItem>
     * @Author: wujingsong
     * @Date: 2019/10/28  11:41 下午
     */
    @RequestMapping(value = "/getByServiceRouteItemId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretBillingIntervalItem> getByServiceRouteItemId(@PathVariable String id) {
        List<PretBillingIntervalItem> pretBillingIntervalItemList = null;
        try {
            Optional<PretServiceRouteItem> pretServiceRouteItemOptional = this.pretServiceRouteItemRepository.findById(id);
            if (pretServiceRouteItemOptional.isPresent()) {
                PretServiceRoute pretServiceRoute = this.pretServiceRouteRepository.findById(pretServiceRouteItemOptional.get().getServiceRouteId()).get();
                return pretBillingIntervalItemList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return pretBillingIntervalItemList;
    }

    /* *
     * 功能描述: 根据计费区间项获取
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretBillingIntervalItem>
     * @Author: wujingsong
     * @Date: 2019/11/2  12:57 上午
     */
    @RequestMapping(value = "/getByBillingInterval/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretBillingIntervalItem> getByBillingInterval(@PathVariable String id) {
        List<PretBillingIntervalItem> pretBillingIntervalItemList = pretBillingIntervalItemRepository.findByBillingIntervalIdAndS(id, ConstantEnum.S.N.getLabel());
        return pretBillingIntervalItemList;
    }
}