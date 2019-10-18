package com.pret.open.service;

import java.util.List;
import java.util.Optional;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.PretGoods;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.PretGoodsRepository;
import com.pret.open.repository.PretPickUpPlanRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.PR1000000Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretTransOrderService extends BaseServiceImpl<PretTransOrderRepository, PretTransOrder, PretTransOrderVo> {
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretPickUpPlanService pretPickUpPlanService;
    @Autowired
    private PretCustomerRepository pretCustomerRepository;
    @Autowired
    private PretGoodsRepository pretGoodsRepository;

    public void genPickUpPlan(PretPickUpPlanBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretPickUpPlan pretPickUpPlan = pretPickUpPlanService.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(pretPickUpPlan, bo);
        pretPickUpPlanRepository.save(pretPickUpPlan);

        for (String id : idArr) {
            PretTransOrder pretTransOrder = this.repository.findById(id).get();
            pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
            this.repository.save(pretTransOrder);
        }
    }

    /* *
     * 功能描述: 下单
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/10  4:49 下午
     */
    public ResBody order(P1000000Vo res) {
        PR1000000Vo retVo = new PR1000000Vo();

        // 客户
        PretCustomer customer = new PretCustomer();
        customer.setLinkPhone(res.getCustTel());
        customer.setLinkName(res.getCustAttn());
        customer.setName(res.getCustName());

        pretCustomerRepository.save(customer);

        // 商品
        PretGoods goods = new PretGoods();
        goods.setUnit(res.getUnit());
        goods.setProduct(res.getProduct());
        goods.setPartNo(res.getPartNo());
        goods.setBatchNo(res.getBatchNo());
        pretGoodsRepository.save(goods);

        PretTransOrder transOrder = new PretTransOrder();
        transOrder.setCustomerId(customer.getId());
        transOrder.setGoodsId(goods.getId());
        transOrder.setCustomerId(customer.getId());
        this.save(transOrder);
        retVo.setData(transOrder);


        return retVo;
    }
}
