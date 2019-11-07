package com.pret.open.service;

import java.util.List;
import java.util.Optional;

import com.google.common.reflect.TypeToken;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.AddressBo;
import com.pret.open.entity.bo.PretMTransOrderBo;
import com.pret.open.entity.bo.PretMTransOrderItemBo;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.repository.*;
import com.pret.open.vo.req.*;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.open.vo.res.PR1000000Vo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;
    @Autowired
    private PretAddressRepository pretAddressRepository;

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

    /* *
     * 功能描述: 手动创建订单
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/7  10:34 上午
     */
    public void pretTransOrderAdd(PretMTransOrderBo bo) {
        List<PretMTransOrderItemBo> list = CommonConstants.GSON.fromJson(bo.getPretMTransOrderItemStr(),
                new TypeToken<List<PretMTransOrderItemBo>>() {
                }.getType());
        if (list != null && list.size() > 0) {
            for (PretMTransOrderItemBo pretMTransOrderBo : list) {
                PretTransOrder pretTransOrder = new PretTransOrder();
                BeanUtilsExtended.copyProperties(pretTransOrder, pretMTransOrderBo);
                BeanUtilsExtended.copyProperties(pretTransOrder, bo);

                // 指定供应商
                List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByCodeAndAddressIdAndS(bo.getPickupFactoryCd(), bo.getAddressId(), ConstantEnum.S.N.getLabel());
                if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
                    pretTransOrder.setVenderId(pretQuotationItemList.get(0).getVenderId());
                } else {
                    PretAddress pretAddress = pretAddressRepository.findById(bo.getAddressId()).get();
                    if (!StringUtils.isEmpty(pretAddress.getParentId())) {
                        pretAddress = pretAddressRepository.findById(pretAddress.getParentId()).get();
                        pretQuotationItemList = pretQuotationItemRepository.findByCodeAndAddressIdAndS(bo.getPickupFactoryCd(), pretAddress.getId(), ConstantEnum.S.N.getLabel());
                        if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
                            pretTransOrder.setVenderId(pretQuotationItemList.get(0).getVenderId());
                        } else {
                            if (!StringUtils.isEmpty(pretAddress.getParentId())) {
                                pretAddress = pretAddressRepository.findById(pretAddress.getParentId()).get();
                                pretQuotationItemList = pretQuotationItemRepository.findByCodeAndAddressIdAndS(bo.getPickupFactoryCd(), pretAddress.getId(), ConstantEnum.S.N.getLabel());
                                if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
                                    pretTransOrder.setVenderId(pretQuotationItemList.get(0).getVenderId());
                                } else {

                                }
                            }
                        }
                    }
                }

                this.repository.save(pretTransOrder);
            }
        }
    }
}
