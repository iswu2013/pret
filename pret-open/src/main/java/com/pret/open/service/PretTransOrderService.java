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
import com.pret.open.vo.res.PR8000004Vo;
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
    private PretServiceRouteItemRepository pretServiceRouteItemRepository;
    @Autowired
    private PretAddressService pretAddressService;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;

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

        PretTransOrder transOrder = new PretTransOrder();
        transOrder.setCustomerId(customer.getId());
        transOrder.setCustomerId(customer.getId());
        BeanUtilsExtended.copyProperties(transOrder, res);
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
                pretTransOrder.setGw(pretMTransOrderBo.getWeight());
                pretTransOrder.setUnit(pretMTransOrderBo.getUnit());
                pretTransOrder.setGoodsNum(pretMTransOrderBo.getGoodsNum());
                BeanUtilsExtended.copyProperties(pretTransOrder, pretMTransOrderBo);
                if (StringUtils.isEmpty(bo.getCustomerName())) {
                    pretTransOrder.setCustomerName(bo.getCustomerLinkName());
                }
                // 设置起运地详细地址
                PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(bo.getServiceRouteOriginId()).get();
                pretTransOrder.setServiceRouteOriginName(pretServiceRouteOrigin.getName());
                String detailAddr = pretAddressService.getDetailByAddressId(pretServiceRouteOrigin.getAddressId()) + pretServiceRouteOrigin.getDetail();
                pretTransOrder.setServiceRouteOriginAddress(detailAddr);
                pretTransOrder.setServiceRouteOriginName(pretServiceRouteOrigin.getName());

                BeanUtilsExtended.copyProperties(pretTransOrder, bo);
                pretTransOrder.setCustomerDetailAddress(pretAddressService.getDetailByAddressId(bo.getAddressId()) + bo.getCustomerAddress());
                BeanUtilsExtended.copyProperties(pretTransOrder, pretMTransOrderBo);
                this.repository.save(pretTransOrder);
                PretCustomer pretCustomer = pretCustomerRepository.findByLinkPhone(bo.getCustomerLinkPhone());
                if (pretCustomer == null) {
                    pretCustomer = new PretCustomer();
                    BeanUtilsExtended.copyProperties(pretCustomer, bo);
                    pretCustomer.setName(bo.getCustomerName());
                    pretCustomer.setLinkName(bo.getCustomerLinkName());
                    pretCustomer.setLinkPhone(bo.getCustomerLinkPhone());
                    pretCustomerRepository.save(pretCustomer);
                }
                pretTransOrder.setCustomerId(pretCustomer.getId());
                // 是否存在同一客户，同一地址，同一送达日期的运输单
                List<Integer> statusList = new ArrayList<>();
                statusList.add(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                statusList.add(ConstantEnum.ETransOrderStatus.待提货.getLabel());
                List<PretTransOrder> pretTransOrderList = this.repository.findByCustomerIdAndAddressIdAndCustomerAddressAndDeliveryDateAndStatusIn(pretCustomer.getId(), bo.getAddressId(), bo.getCustomerAddress(), bo.getDeliveryDate(), statusList);

                List<String> pretAddressList = pretAddressService.findAddressListByAddressId(bo.getAddressId());
                List<PretServiceRouteItem> pretServiceRouteItemList = pretServiceRouteItemRepository.findByCodeAndAddressIdInAndS(bo.getPickupFactoryCd(), pretAddressList, ConstantEnum.S.N.getLabel());
                this.calBillingInterval(pretTransOrderList, pretTransOrder, true, pretServiceRouteItemList);

            }
        }
    }

    /* *
     * 功能描述: 查找供应商
     * 〈〉
     * @Param: [pretTransOrderList, isHeavyCargo, pretServiceRouteItemList]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/9  10:53 上午
     */
    public void calBillingInterval(List<PretTransOrder> pretTransOrderList, PretTransOrder transOrder, boolean isHeavyCargo, List<PretServiceRouteItem> pretServiceRouteItemList) {
        Float totalGw = 0.0f;
        String venderId = StringUtils.EMPTY;
        for (PretTransOrder pretTransOrder : pretTransOrderList) {
            if (pretTransOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                totalGw += pretTransOrder.getGw() * pretTransOrder.getGoodsNum();
            } else {
                totalGw += pretTransOrder.getGw() * pretTransOrder.getGoodsNum() * 1000;
            }
            venderId = pretTransOrder.getVenderId();
        }

        if (StringUtils.isEmpty(venderId)) {
            for (PretServiceRouteItem item : pretServiceRouteItemList) {
                if (isHeavyCargo && totalGw > item.getLowerLimit()) {
                    for (PretTransOrder pretTransOrder : pretTransOrderList) {
                        pretTransOrder.setVenderId(item.getVenderId());
                        transOrder.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
                    }
                    this.repository.saveAll(pretTransOrderList);
                }
            }
        } else {
            transOrder.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
            transOrder.setVenderId(venderId);
            this.repository.save(transOrder);
        }
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
        pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待提货.getLabel());
        this.repository.save(pretTransOrder);
    }

    /* *
     * 功能描述: 删除订单
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/11/21  11:59 上午
     */
    public ResBody deleteOrder(P8000004Vo res) {
        PR8000004Vo retVo = new PR8000004Vo();

        PretTransOrder pretTransOrder = this.repository.findBySourceCode(res.getSourceCode());
        this.lDelete(pretTransOrder.getId());

        return retVo;
    }
}
