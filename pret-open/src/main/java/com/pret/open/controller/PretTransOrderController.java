package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretGoodsRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretTransOrderService;
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
@RequestMapping("pretTransOrder")
public class PretTransOrderController extends BaseManageController<PretTransOrderService, PretTransOrder, PretTransOrderVo> {
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretGoodsRepository pretGoodsRepository;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretTransOrder view(@PathVariable String id) throws FebsException {
        try {
            PretTransOrder item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @GetMapping
    @Override()
    public Map<String, Object> list(PretTransOrderVo request, PretTransOrder t) {
        Page<PretTransOrder> page = this.service.page(request);
        for (PretTransOrder route : page.getContent()) {
            if (!StringUtils.isEmpty(route.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(route.getVenderId()).get();
                route.setPretVender(pretVender);
            }
            if (!StringUtils.isEmpty(route.getGoodsId())) {
                PretGoods pretGoods = pretGoodsRepository.findById(route.getGoodsId()).get();
                route.setPretGoods(pretGoods);
            }
            if (!StringUtils.isEmpty(route.getCustomerId())) {
                PretCustomer pretCustomer = pretCustomerRepository.findById(route.getCustomerId()).get();
                route.setPretCustomer(pretCustomer);
            }
        }
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", page.getContent());
        rspData.put("total", page.getTotalElements());

        return rspData;
    }

    /* *
     * 功能描述: 根据运输计划查找
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/2  11:00 上午
     */
    @RequestMapping(value = "/getByTansPlanId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretTransOrder> getByTansPlanId(@PathVariable String id) {
        List<PretTransOrder> transOrderList = pretTransOrderRepository.findByTransPlanIdAndS(id, ConstantEnum.S.N.getLabel());
        return transOrderList;
    }
}