package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.vo.PretBillingIntervalItemVo;
import com.pret.open.repository.PretBillingIntervalItemRepository;
import com.pret.open.repository.PretServiceRouteItemRepository;
import com.pret.open.repository.PretServiceRouteRepository;
import com.pret.open.service.PretBillingIntervalItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 功能描述: 根据计费区间项和类别获取
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretBillingIntervalItem>
     * @Author: wujingsong
     * @Date: 2019/11/2  12:57 上午
     */
    @RequestMapping(value = "/getByBillingInterval/{id}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretBillingIntervalItem> getByBillingInterval(@PathVariable String id, @PathVariable Integer type) {
        List<PretBillingIntervalItem> pretBillingIntervalItemList = pretBillingIntervalItemRepository.findByBillingIntervalIdAndTypeAndS(id, type, ConstantEnum.S.N.getLabel());
        return pretBillingIntervalItemList;
    }

    /* *
     * 功能描述: 根据计费区间项获取
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretBillingIntervalItem>
     * @Author: wujingsong
     * @Date: 2019/11/9  2:46 下午
     */
    @RequestMapping(value = "/getByBillingInterval/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretBillingIntervalItem> getByBillingInterval(@PathVariable String id) {
        List<PretBillingIntervalItem> pretBillingIntervalItemList = pretBillingIntervalItemRepository.findByBillingIntervalIdAndS(id, ConstantEnum.S.N.getLabel());
        return pretBillingIntervalItemList;
    }
}