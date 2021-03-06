package com.pret.open.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.google.common.reflect.TypeToken;
import com.pret.common.constant.CommonConstants;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.common.utils.HttpUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransExceptionBo;
import com.pret.open.entity.bo.PretTransExceptionItemBo;
import com.pret.open.entity.bo.U9ReturnBo;
import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.repository.*;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
public class PretTransExceptionService extends BaseServiceImpl<PretTransExceptionRepository, PretTransException, PretTransExceptionVo> {
    @Autowired
    private PretTransExceptionItemRepository pretTransExceptionItemRepository;
    @Autowired
    private PretTransExceptionHandleRecordRepository pretTransExceptionHandleRecordRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretAddressService pretAddressService;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretServiceRouteOriginRepository pretServiceRouteOriginRepository;
    @Autowired
    private PretTransPlanService pretTransPlanService;
    @Autowired
    private PretTransOrderGroupRepository pretTransOrderGroupRepository;
    @Autowired
    private PretTransFeeItemRepository pretTransFeeItemRepository;
    @Autowired
    private PretTransFeeRepository pretTransFeeRepository;
    @Autowired
    private PretTransFeeItemService pretTransFeeItemService;

    /* *
     * 功能描述: 生成默认异常单
     * 〈〉
     * @Param: [no, tail]
     * @Return: com.pret.open.entity.PretTransException
     * @Author: wujingsong
     * @Date: 2019/10/4  10:34 下午
     */
    public PretTransException genDefaultPretTransException(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransException transException = new PretTransException();

        if (!StringUtils.isEmpty(no)) {
            transException.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransException firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(8));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                transException.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.EX.name()) + tail);
            }
        }

        return transException;
    }

    /* *
     * 功能描述: 结案
     * 〈〉
     * @Param: [id]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/24  5:56 下午
     */
    public void closeCase(String id) {
        PretTransException exception = this.repository.findById(id).get();
        exception.setStatus(ConstantEnum.EHandleStatus.已结案.getLabel());
        exception.setCloseTime(new Date().getTime());
        this.repository.save(exception);
    }

    /* *
     * 功能描述: 赔款到账
     * 〈〉
     * @Param: [id]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/25  3:59 上午
     */
    public void indemnityAccount(PretTransExceptionHandleRecord record) {
        PretTransException pretTransException = this.repository.findById(record.getExceptionId()).get();
//        PretTransPlan pretTransPlan = pretTransPlanRepository.findById(pretTransException.getTransPlanId()).get();
//        if (pretTransPlan.getStatus() == ConstantEnum.ETransPlanStatus.已签收.getValue()) {
//            pretTransException.setStatus(ConstantEnum.ETransExceptionStatus.已结案.getLabel());
//            pretTransException.setCloseTime(new Date().getTime());
//        }
        pretTransException.setCompensationStatus(ConstantEnum.ECompensationStatus.已赔款.getLabel());
        this.repository.save(pretTransException);
        record.setDescription(ConstantEnum.EHandleDescription.赔款到账.name());
        record.setType(ConstantEnum.EHandleType.货主.getLabel());
        pretTransExceptionHandleRecordRepository.save(record);
    }

    /* *
     * 功能描述: 创建返程运输单
     * 〈〉
     * @Param: [pretTransException]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/25  5:10 上午
     */
    public void genRTransPlan(PretTransException pretTransException) {
        List<PretTransExceptionItem> pretTransExceptionItemList = pretTransExceptionItemRepository.findByTransExceptionIdAndS(pretTransException.getId(), ConstantEnum.S.N.getLabel());
//        PretTransPlan pretTransPlan = new PretTransPlan();
//
//        PretTransPlan oldTransPlan = pretTransPlanRepository.findById(pretTransException.getTransPlanId()).get();
//        pretTransPlan.setCustomerId(pretTransException.getCustomerId());
//        pretTransPlan.setServiceRouteOriginAddress(pretTransException.getAddressDetail());
//        pretTransPlan.setCustomerDetailAddress(pretTransException.getReturnAddress());
//        pretTransPlan.setType(ConstantEnum.EPretTransPlanType.退货运输.getLabel());
//        pretTransPlan.setCustomerId(pretTransException.getCustomerId());
//        pretTransPlan.setNo("B" + oldTransPlan.getNo());
//        pretTransPlan.setStatus(ConstantEnum.ETransPlanStatus.待起运.getValue());
//        pretTransPlanRepository.save(pretTransPlan);

        PretTransOrderGroup pretTransOrderGroup = null;

        for (PretTransExceptionItem pretTransExceptionItem : pretTransExceptionItemList) {
            PretTransOrder old = pretTransOrderRepository.findById(pretTransExceptionItem.getTransOrderId()).get();

            PretTransOrder pretTransOrder = new PretTransOrder();
            BeanUtilsExtended.copyPropertiesIgnore(pretTransOrder, old, "id");
            pretTransOrder.setDeliveryBillNumber("B" + pretTransOrder.getDeliveryBillNumber());
            pretTransOrder.setCustomerDetailAddress(old.getServiceRouteOriginAddress());
            pretTransOrder.setServiceRouteOriginAddress(old.getCustomerDetailAddress());
//            pretTransOrder.setTransPlanId(pretTransPlan.getId());
            pretTransOrder.setType(ConstantEnum.EPretTransOrderType.返程配送单.getLabel());
            pretTransOrder.setServiceRouteOriginAddress(pretTransException.getAddressDetail());
            pretTransOrder.setCustomerDetailAddress(pretTransException.getReturnAddress());
            pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待分配.getLabel());
            pretTransOrder.setOriginId(pretTransExceptionItem.getTransOrderId());
            //pretTransOrder.setAddressId();

            if (pretTransOrderGroup == null) {
                pretTransOrderGroup = new PretTransOrderGroup();
                BeanUtilsExtended.copyPropertiesIgnore(pretTransOrderGroup, pretTransOrder);
                pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.待分配.getLabel());
                pretTransOrderGroupRepository.save(pretTransOrderGroup);
            }

            pretTransOrder.setTransOrderGroupId(pretTransOrderGroup.getId());
            pretTransOrderRepository.save(pretTransOrder);
        }
//        pretTransException.setTransNo(pretTransPlan.getNo());
        pretTransException.setIsReturnStatus(1);
        pretTransException.setReturnStatus(2);
        pretTransException.setCreatedReturn(ConstantEnum.EcreatedReturn.是.getLabel());
        this.repository.save(pretTransException);
    }

    /* *
     * 功能描述: 处理
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/25  7:40 上午
     */
    public void handle(PretTransExceptionBo bo) {
        PretTransException exception = this.repository.findById(bo.getId()).get();
        BeanUtilsExtended.copyProperties(exception, bo);
        if (bo.getReturnType() != null && bo.getReturnType() == ConstantEnum.EReturnType.提货工厂.getLabel()) {
            PretTransPlan pretTransPlan = pretTransPlanRepository.findById(exception.getTransPlanId()).get();
            PretServiceRouteOrigin pretServiceRouteOrigin = pretServiceRouteOriginRepository.findById(pretTransPlan.getServiceRouteOriginId()).get();
            exception.setReturnAddress(pretServiceRouteOrigin.getFullAddress());
            exception.setLinkName(pretServiceRouteOrigin.getLinkMan());
            exception.setLinkPhone(pretServiceRouteOrigin.getLinkPhone());
        } else if (bo.getReturnType() != null && bo.getReturnType() == ConstantEnum.EReturnType.提货工厂.getLabel()) {
            if (!StringUtils.isEmpty(bo.getAddressId())) {
                String address = pretAddressService.getDetailByAddressId(bo.getAddressId());
                exception.setReturnAddress(address + bo.getAddressDetail());
            }
        }
        exception.setStatus(ConstantEnum.ETransExceptionStatus.已认定.getLabel());
        if (exception.getCompensation() != null && exception.getCompensation().doubleValue() > 0) {
            exception.setCompensationStatus(ConstantEnum.ECompensationStatus.未赔款.getLabel());
        }

        PretTransExceptionHandleRecord pretTransExceptionHandleRecord = new PretTransExceptionHandleRecord();
        BeanUtilsExtended.copyProperties(pretTransExceptionHandleRecord, bo);
        pretTransExceptionHandleRecord.setType(ConstantEnum.EHandleType.货主.getLabel());
        pretTransExceptionHandleRecord.setDescription(ConstantEnum.EHandleDescription.责任认定.name());
        pretTransExceptionHandleRecord.setHandleUserName(bo.getHandleUserName());
        pretTransExceptionHandleRecord.setHandleUserId(bo.getHandleUserId());
        pretTransExceptionHandleRecord.setExceptionId(bo.getId());
        pretTransExceptionHandleRecordRepository.save(pretTransExceptionHandleRecord);
        this.repository.save(exception);

        // 编辑异常费用
        PretTransFee pretTransFee = pretTransFeeRepository.findById(bo.getTransFeeId()).get();
        List<PretTransFeeItem> list = CommonConstants.GSON.fromJson(bo.getPretTransFeeStr(),
                new TypeToken<List<PretTransFeeItem>>() {
                }.getType());
        List<PretTransFeeItem> pretTransFeeItemList = pretTransFeeItemRepository.findByExceptionFeeAndS(ConstantEnum.EYesOrNo.是.getLabel(), ConstantEnum.S.N.getLabel());
        if (pretTransFeeItemList != null && pretTransFeeItemList.size() > 0) {
            for (PretTransFeeItem pretTransFeeItem : pretTransFeeItemList) {
                pretTransFeeItemService.lDelete(pretTransFeeItem.getId());
            }
        }
        if (list != null && list.size() > 0) {
            for (PretTransFeeItem item : list) {
                item.setVenderId(pretTransFee.getVenderId());
                item.setTransFeeId(pretTransFee.getId());
                item.setExceptionFee(ConstantEnum.EYesOrNo.是.getLabel());
            }
            pretTransFeeItemRepository.saveAll(list);
            pretTransFeeRepository.save(pretTransFee);
        }
    }

    /* *
     * 功能描述: 更新异常
     * 〈〉
     * @Param: [pretTransExceptionHandleRecord]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/27  8:04 上午
     */
    public void updateException(PretTransExceptionHandleRecord pretTransExceptionHandleRecord) {
        pretTransExceptionHandleRecordRepository.save(pretTransExceptionHandleRecord);
    }
}
