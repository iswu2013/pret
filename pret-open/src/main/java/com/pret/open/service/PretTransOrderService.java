package com.pret.open.service;

import java.util.ArrayList;
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
    @Autowired
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;

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
                if (StringUtils.isEmpty(bo.getCustomerName())) {
                    pretTransOrder.setCustomerName(bo.getCustomerLinkName());
                }
                BeanUtilsExtended.copyProperties(pretTransOrder, bo);
                PretCustomer pretCustomer = pretCustomerRepository.findByLinkPhone(bo.getCustomerLinkPhone());
                // 是否存在同一客户，同一地址，同一送达日期的运输单
                boolean hasE = false;
                if (pretCustomer != null) {
                    List<Integer> statusList = new ArrayList<>();
                    statusList.add(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                    statusList.add(ConstantEnum.ETransOrderStatus.待提货.getLabel());
                    List<PretTransOrder> pretTransOrderList = this.repository.findByCustomerIdAndAddressIdAndCustomerAddressAndDeliveryDateAndStatusIn(pretCustomer.getId(), bo.getAddressId(), bo.getCustomerAddress(), bo.getDeliveryDate(), statusList);
                    float total = 0.0f;
                    if (pretTransOrderList != null) {
                        for (PretTransOrder transOrder : pretTransOrderList) {
                            if (transOrder.getGoodsType() == ConstantEnum.EGoodsType.重货.getLabel()) {
                                if (transOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                                    total += transOrder.getGw() * transOrder.getGoodsNum();
                                } else {
                                    total += transOrder.getGw() * transOrder.getGoodsNum() * 1000;
                                }
                            }
                        }
                        List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByVenderIdAndS(pretTransOrderList.get(0).getVenderId(), ConstantEnum.S.N.getLabel());
                        PretBillingIntervalItem pretBillingIntervalItem = this.calBillingInterval(pretTransOrder, total, true, pretQuotationItemList);
                        if (pretBillingIntervalItem != null) {
                            for (PretTransOrder transOrder : pretTransOrderList) {
                                transOrder.setBillingIntervalItemId(pretBillingIntervalItem.getId());
                                this.repository.save(pretTransOrder);
                            }
                        }
                    }
                }

                if (!hasE) {
                    // 查找线路,指定供应商
                    // 重量
                    float total = 0.0f;
                    boolean isHeavyCargo = true;

                    if (pretTransOrder.getGw() != null && pretTransOrder.getGw().floatValue() > 0) {
                        if (pretTransOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                            total = pretTransOrder.getGw() * pretTransOrder.getGoodsNum();
                        } else {
                            total = pretTransOrder.getGw() * pretTransOrder.getGoodsNum() * 1000;
                        }
                        pretTransOrder.setGoodsType(ConstantEnum.EGoodsType.重货.getLabel());
                    }
                    if (pretTransOrder.getCbm() != null && pretTransOrder.getCbm().floatValue() > 0) {
                        total = pretTransOrder.getCbm() * pretTransOrder.getGoodsNum();
                        isHeavyCargo = false;
                        pretTransOrder.setGoodsType(ConstantEnum.EGoodsType.泡货.getLabel());
                    }


                    PretAddress pretAddress = pretAddressRepository.findById(bo.getAddressId()).get();
                    List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByCodeAndAddressIdAndS(bo.getPickupFactoryCd(), pretAddress.getId(), ConstantEnum.S.N.getLabel());
                    if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
                        this.calBillingInterval(pretTransOrder, total, isHeavyCargo, pretQuotationItemList);
                    } else {
                        if (!StringUtils.isEmpty(pretAddress.getParentId())) {
                            pretAddress = pretAddressRepository.findById(pretAddress.getParentId()).get();
                            pretQuotationItemList = pretQuotationItemRepository.findByCodeAndAddressIdAndS(bo.getPickupFactoryCd(), pretAddress.getId(), ConstantEnum.S.N.getLabel());
                            if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
                                this.calBillingInterval(pretTransOrder, total, isHeavyCargo, pretQuotationItemList);
                            } else {
                                if (!StringUtils.isEmpty(pretAddress.getParentId())) {
                                    pretQuotationItemList = pretQuotationItemRepository.findByCodeAndAddressIdAndS(bo.getPickupFactoryCd(), pretAddress.getParentId(), ConstantEnum.S.N.getLabel());
                                    if (pretQuotationItemList != null && pretQuotationItemList.size() > 0) {
                                        this.calBillingInterval(pretTransOrder, total, isHeavyCargo, pretQuotationItemList);
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

    /* *
     * 功能描述: 计算区间
     * 〈〉
     * @Param: [pretTransOrder, total, isHeavyCargo, pretQuotationItemList]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/9  8:01 上午
     */
    public PretBillingIntervalItem calBillingInterval(PretTransOrder pretTransOrder, float total, boolean isHeavyCargo, List<PretQuotationItem> pretQuotationItemList) {
        PretBillingIntervalItem pretBillingIntervalItem = null;
        for (PretQuotationItem item : pretQuotationItemList) {
            pretBillingIntervalItem = pretBillingIntervalItemRepository.findById(item.getBillingIntervalItemId()).get();
            PretServiceRouteItem pretServiceRouteItem = pretServiceRouteItemRepository.findById(item.getServiceRouteItemId()).get();
            if (isHeavyCargo) {
                if (pretBillingIntervalItem.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                    if (total > pretBillingIntervalItem.getStart() && total < pretBillingIntervalItem.getEnd() && total > pretServiceRouteItem.getLowerLimit()) {
                        pretTransOrder.setBillingIntervalItemId(pretBillingIntervalItem.getId());
                        pretTransOrder.setVenderId(item.getVenderId());

                        return pretBillingIntervalItem;
                    }
                } else if (pretBillingIntervalItem.getUnit() == ConstantEnum.EUnit.吨.getLabel()) {
                    if (total > pretBillingIntervalItem.getStart() * 1000 && total < pretBillingIntervalItem.getEnd() * 1000 && total > pretServiceRouteItem.getLowerLimit()) {
                        pretTransOrder.setBillingIntervalItemId(pretBillingIntervalItem.getId());
                        pretTransOrder.setVenderId(item.getVenderId());

                        return pretBillingIntervalItem;
                    }
                }
            } else {
                if (total > pretBillingIntervalItem.getStart() && total < pretBillingIntervalItem.getEnd()) {
                    pretTransOrder.setBillingIntervalItemId(pretBillingIntervalItem.getId());
                    pretTransOrder.setVenderId(item.getVenderId());

                    return pretBillingIntervalItem;
                }
            }
        }

        return null;
    }

    /* *
     * 功能描述: 指定供应商
     * 〈〉
     * @Param: [id, venderId]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/9  8:51 上午
     */
    public void allocateVender(String id, String venderId) {
        PretTransOrder pretTransOrder = this.repository.findById(id).get();
        pretTransOrder.setVenderId(venderId);
        this.repository.save(pretTransOrder);

        List<Integer> statusList = new ArrayList<>();
        statusList.add(ConstantEnum.ETransOrderStatus.待分配.getLabel());
        statusList.add(ConstantEnum.ETransOrderStatus.待提货.getLabel());
        List<PretTransOrder> pretTransOrderList = this.repository.findByCustomerIdAndAddressIdAndCustomerAddressAndDeliveryDateAndStatusIn(pretTransOrder.getId(), pretTransOrder.getAddressId(), pretTransOrder.getCustomerAddress(), pretTransOrder.getDeliveryDate(), statusList);
        float total = 0.0f;
        if (pretTransOrderList != null) {
            for (PretTransOrder transOrder : pretTransOrderList) {
                if (transOrder.getGoodsType() == ConstantEnum.EGoodsType.重货.getLabel()) {
                    if (transOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                        total += transOrder.getGw() * transOrder.getGoodsNum();
                    } else {
                        total += transOrder.getGw() * transOrder.getGoodsNum() * 1000;
                    }
                }
            }
            List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByVenderIdAndS(pretTransOrderList.get(0).getVenderId(), ConstantEnum.S.N.getLabel());
            PretBillingIntervalItem pretBillingIntervalItem = this.calBillingInterval(pretTransOrder, total, true, pretQuotationItemList);
            if (pretBillingIntervalItem != null) {
                for (PretTransOrder transOrder : pretTransOrderList) {
                    transOrder.setBillingIntervalItemId(pretBillingIntervalItem.getId());
                    this.repository.save(pretTransOrder);
                }
            }
        }
    }
}
