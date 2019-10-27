package com.pret.open.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransStatementBo;
import com.pret.open.entity.vo.PretTransStatementVo;
import com.pret.open.repository.PretTransFeeRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.repository.PretTransPlanRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransStatementRepository;
import com.pret.api.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
public class PretTransStatementService extends BaseServiceImpl<PretTransStatementRepository, PretTransStatement, PretTransStatementVo> {
    @Autowired
    private PretTransFeeRepository transFeeRepository;
    @Autowired
    private PretTransStatementRepository transStatementRepository;
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretTransPlanRepository transPlanRepository;

    public PretTransStatement genDefaultPretPickUpPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransStatement transStatement = new PretTransStatement();

        if (!StringUtils.isEmpty(no)) {
            transStatement.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransStatement firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                transStatement.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TH.name()) + tail);
            }
        }

        return transStatement;
    }

    /* *
     * 功能描述: 生成对账作业
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  5:43 下午
     */
    public void genTransStatement(PretTransStatementBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretTransStatement transStatement = this.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(transStatement, bo);
        try {
            transStatement.setPeriodFrom(DateUtils.parseDate(bo.getPeriodFromStr(), "yyyy-MM-dd"));
            transStatement.setPeriodTo(DateUtils.parseDate(bo.getPeriodToStr(), "yyyy-MM-dd"));
            transStatement.setStatus(ConstantEnum.ETransStatementStatus.待确认.getLabel());
            transStatement.setCheckDate(new Date());
            this.repository.save(transStatement);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (String id : idArr) {
            PretTransFee transFee = transFeeRepository.findById(id).get();
            transFee.setTransStatementId(transStatement.getId());
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.通过.getLabel());
            transFeeRepository.save(transFee);
            totalAmount = totalAmount.add(transFee.getQuotation());

            PretTransPlan pretTransPlan = transPlanRepository.findById(transFee.getTransPanId()).get();
            List<PretTransOrder> pretTransOrderList = transOrderRepository.findByTransPlanId(pretTransPlan.getId());
            for (PretTransOrder pretTransOrder : pretTransOrderList) {
                pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已完成.getLabel());
                transOrderRepository.save(pretTransOrder);
            }
        }

        transStatement.setTotalAmount(totalAmount);
        transStatement.setRealAmount(totalAmount);
        this.repository.save(transStatement);

        // 对接U9
    }

    /* *
     * 功能描述: 对账确认
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  5:48 下午
     */
    public void confirmStatement(String ids) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            // 对接U9

            PretTransStatement transStatement = transStatementRepository.findById(id).get();
            transStatement.setStatus(ConstantEnum.ETransStatementStatus.已转U9.getLabel());
            transStatementRepository.save(transStatement);

            List<PretTransOrder> transOrderList = transOrderRepository.findByTransStatementId(id);
            if (transOrderList != null && transOrderList.size() > 0) {
                for (PretTransOrder pretTransOrder : transOrderList) {
                    pretTransOrder.setStatus(ConstantEnum.ETransOrderStatus.已完成.getLabel());
                    transOrderRepository.save(pretTransOrder);
                }
            }
        }
    }
}
