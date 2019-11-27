package com.pret.open.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.exception.FebsException;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransPlanSignBo;
import com.pret.open.entity.vo.PretTransFeeVo;
import com.pret.open.repository.*;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PretTransFeeService extends BaseServiceImpl<PretTransFeeRepository, PretTransFee, PretTransFeeVo> {
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretBillingIntervalItemRepository pretBillingIntervalItemRepository;
    @Autowired
    private PretQuotationItemRepository pretQuotationItemRepository;
    @Autowired
    private PretFeeTypeRepository pretFeeTypeRepository;
    @Autowired
    private PretTransExceptionRepository pretTransExceptionRepository;

    public PretTransFee genDefaultPretTransFee(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransFee transFee = new PretTransFee();

        if (!StringUtils.isEmpty(no)) {
            transFee.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransFee firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(7));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                transFee.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.R.name()) + tail);
            }
        }

        return transFee;
    }


    /* *
     * 功能描述: 费用申报
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  5:29 下午
     */
    public void transFeeAppl(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            PretTransFee transFee = this.repository.findById(id).get();
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.已申报.getLabel());
            this.repository.save(transFee);
        }
    }

    /* *
     * 功能描述: 根据运输计划计算费用
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/19  5:57 下午
     */
    public void calFee(PretTransPlanSignBo bo) throws FebsException {
        String id = bo.getId();
        boolean first = true;
        int sn = 0;
        Float totalGw = 0.0f;
        PretTransPlan pretTransPlan = pretTransPlanRepository.findById(id).get();
        pretTransPlan.setStatus(ConstantEnum.ETransPlanStatus.已签收.getValue());
        pretTransPlan.setSignUsername(bo.getUsername());
        pretTransPlan.setSignDatetime(bo.getSignDatetime());
        pretTransPlanRepository.save(pretTransPlan);

        PretTransException pretTransException = null;
        if (!StringUtils.isEmpty(pretTransPlan.getTransExceptionId())) {
            pretTransException = pretTransExceptionRepository.findById(pretTransPlan.getTransExceptionId()).get();
        }
        if (pretTransPlan.getType() == ConstantEnum.EPretTransPlanType.正常运输.getLabel() || (pretTransException != null && pretTransException.getHandleStyle() == ConstantEnum.EHandleStyle.原路返回.getLabel())) {
            List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByTransPlanIdAndS(id, ConstantEnum.S.N.getLabel());
            if (pretTransOrderList != null && pretTransOrderList.size() > 0) {
                for (PretTransOrder pretTransOrder : pretTransOrderList) {
                    pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.签收.getLabel());
                    pretTransOrderRepository.save(pretTransOrder);
                    if (pretTransOrder.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                        totalGw += pretTransOrder.getGw();
                    } else {
                        totalGw += pretTransOrder.getGw() * 1000;
                    }
                }
            }

            List<PretQuotationItem> pretQuotationItemList = pretQuotationItemRepository.findByVenderIdAndS(pretTransPlan.getVenderId(), ConstantEnum.S.N.getLabel());
            for (PretQuotationItem pretQuotationItem : pretQuotationItemList) {
                // 生成费用
                PretTransFee pretTransFee;
                if (first) {
                    pretTransFee = this.genDefaultPretTransFee(null, null);
                    sn = Integer.parseInt(pretTransFee.getNo().substring(7));
                } else {
                    sn++;
                    // 生成费用
                    pretTransFee = new PretTransFee();
                    String tail = StringUtil.addFrontZero(String.valueOf(sn), 6);
                    pretTransFee.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.R.name()) + tail);
                    first = false;
                }
                pretTransFee.setTransPlanId(id);
                pretTransFee.setVenderId(pretTransPlan.getVenderId());
                pretTransFee.setCustomerId(pretTransPlan.getCustomerId());
                PretBillingIntervalItem pretBillingIntervalItem = pretBillingIntervalItemRepository.findById(pretQuotationItem.getBillingIntervalItemId()).get();
                if (pretBillingIntervalItem.getUnit() == ConstantEnum.EUnit.公斤.getLabel()) {
                    PretFeeType pretFeeType = pretFeeTypeRepository.findById(pretQuotationItem.getFeeTypeId()).get();
                    if (pretFeeType.getType() == ConstantEnum.ECostType.量.getLabel()) {
                        pretTransFee.setQuotation(pretQuotationItem.getQuotation().multiply(new BigDecimal(totalGw)));
                    } else {
                        pretTransFee.setQuotation(pretQuotationItem.getQuotation());
                    }
                } else {
                    totalGw = totalGw / 1000;
                    PretFeeType pretFeeType = pretFeeTypeRepository.findById(pretQuotationItem.getFeeTypeId()).get();
                    if (pretFeeType.getType() == ConstantEnum.ECostType.量.getLabel()) {
                        pretTransFee.setQuotation(pretQuotationItem.getQuotation().multiply(new BigDecimal(totalGw)));
                    } else {
                        pretTransFee.setQuotation(pretQuotationItem.getQuotation());
                    }
                }

                pretTransFee.setQuotationCount(totalGw);
                pretTransFee.setStatus(ConstantEnum.EPretTransFeeStatus.待申报.getLabel());
                pretTransFee.setUnitPrice(pretTransFee.getQuotation().divide(new BigDecimal(totalGw)));
                this.repository.save(pretTransFee);
            }

            if (!StringUtils.isEmpty(pretTransPlan.getTransExceptionId())) {
                if (pretTransException.getHandleStatus() == ConstantEnum.EHandleStatus.已付赔款.getLabel()) {
                    pretTransException.setHandleStatus(ConstantEnum.EHandleStatus.已结案.getLabel());
                    pretTransExceptionRepository.save(pretTransException);
                }
            }
        }
    }
}
