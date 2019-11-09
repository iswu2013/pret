package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.FebsException;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretMTransOrderBo;
import com.pret.open.entity.bo.PretTransPlanBo;
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

import java.util.Date;
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

    @Log("手动创建订单")
    @PostMapping("/pretTransOrderAdd")
    public void pretTransOrderAdd(PretMTransOrderBo bo) throws FebsException {
        try {
            this.service.pretTransOrderAdd(bo);
        } catch (Exception e) {
            message = "生成运输计划失败";
            throw new FebsException(message);
        }
    }

    @Log("查看")
    @PostMapping("/allocateVender/{id}/{venderId}")
    public void allocateVender(@PathVariable String id, @PathVariable String venderId) throws FebsException {
        try {
            this.service.allocateVender(id,venderId);
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    @Log("创建物流单")
    @PostMapping("/createTestData")
    public void createTestData() throws FebsException {
        try {
            for (int i = 0; i < 10; i++) {
                PretTransOrder pretTransOrder = new PretTransOrder();
                pretTransOrder.setCustomerAddress("上海市闵行区闵柏物流" + i % 5);
                PretCustomer pretCustomer = new PretCustomer();
                pretCustomer.setName("客户" + i % 5);
                pretCustomer.setLinkName("客户" + i % 5);
                pretCustomer.setLinkPhone("1378777777" + i % 5);
                pretCustomerRepository.save(pretCustomer);
                pretTransOrder.setCustomerId(pretCustomer.getId());
                pretTransOrder.setCustomerLinkName("客户" + i % 5);
                pretTransOrder.setCustomerAddress("上海市闵行区闵柏物流" + i % 5);
                pretTransOrder.setCustomerLinkPhone("1378777777" + i % 5);
                pretTransOrder.setDeliveryBillNumber("20191001" + i % 8);
                pretTransOrder.setDeliveryDate(new Date());
                pretTransOrder.setOrderNo(Constants.df_yyyyMMddHHmmssSSS.format(new Date()));
                pretTransOrder.setTakeDeliveryDate(new Date());
                pretTransOrder.setServiceRouteOrginId("SH-JX");
                pretTransOrder.setTransMode("陆运");

                PretVender pretVender = pretVenderRepository.findTop1ByOrderByCreateTimeLongDesc();
                pretTransOrder.setVenderId(pretVender.getId());
                pretTransOrder.setGw(Float.valueOf((i % 7)));

                PretGoods pretGoods = new PretGoods();
                pretGoods.setBatchNo("B100");
                pretGoods.setPartNo("P100");
                pretGoods.setProduct("平板电脑");
                pretGoods.setUnit(i % 2);
                pretGoodsRepository.save(pretGoods);

                pretTransOrder.setGoodsId(pretGoods.getId());
                pretTransOrder.setGoodsNum(i % 9);

                pretTransOrderRepository.save(pretTransOrder);
            }
        } catch (Exception e) {
            message = "创建物流单";
            throw new FebsException(message);
        }
    }
}