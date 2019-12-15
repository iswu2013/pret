package com.pret.open.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransStatementBo;
import com.pret.open.entity.vo.PretTransStatementVo;
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
public class PretTransStatementService extends BaseServiceImpl<PretTransStatementRepository, PretTransStatement, PretTransStatementVo> {
    @Autowired
    private PretTransFeeRepository transFeeRepository;
    @Autowired
    private PretTransStatementRepository transStatementRepository;
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretTransPlanRepository transPlanRepository;
    @Autowired
    private PretTransFeeRepository pretTransFeeRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretTransStatementRecordRepository pretTransStatementRecordRepository;

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
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(7));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 4);
                } else {
                    tail = Constants.TAIL;
                }
                transStatement.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.P.name()) + tail);
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
            transStatement.setStatus(ConstantEnum.ETransStatementStatus.对账待确认.getLabel());
            transStatement.setCheckDate(new Date());
            transStatement.setCurrencyId(bo.getCurrencyId());
            this.repository.save(transStatement);

            // 添加一条记录
            PretTransStatementRecord pretTransFeeRecord = new PretTransStatementRecord();

            pretTransFeeRecord.setDescription(ConstantEnum.EPretTransStatementDescription.创建对账单.name());
            pretTransFeeRecord.setTransStatementId(transStatement.getId());
            pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel());
            pretTransFeeRecord.setUsername(bo.getUsername());
            pretTransStatementRecordRepository.save(pretTransFeeRecord);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        BigDecimal totalAmount = BigDecimal.ZERO;
        String deptId = StringUtils.EMPTY;
        Float totalGw = 0.0f;
        Float totalSignGw = 0.0f;
        for (String id : idArr) {
            PretTransFee transFee = transFeeRepository.findById(id).get();
            transFee.setTransStatementId(transStatement.getId());
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.已对账.getLabel());
            transFeeRepository.save(transFee);
            totalAmount = totalAmount.add(transFee.getQuotation());
            totalGw += transFee.getQuotationCount();


            PretTransPlan pretTransPlan = transPlanRepository.findById(transFee.getTransPlanId()).get();
            pretTransPlan.setTransStatementId(transStatement.getId());
            transPlanRepository.save(pretTransPlan);
            totalSignGw += pretTransPlan.getSignGw();
            if (StringUtils.isEmpty(deptId)) {
                deptId = pretTransPlan.getDeptId();
            }
        }
        transStatement.setDeptId(deptId);
        transStatement.setTotalGw(totalGw);
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
    public void confirmStatement(String ids, String username) {
        String[] idArr = ids.split(",");
        for (String id : idArr) {
            // 对接U9
            PretTransStatement transStatement = transStatementRepository.findById(id).get();
            transStatement.setStatus(ConstantEnum.ETransStatementStatus.对账已确认.getLabel());
            transStatementRepository.save(transStatement);

            // 添加一条记录
            PretTransStatementRecord pretTransFeeRecord = new PretTransStatementRecord();

            pretTransFeeRecord.setDescription(ConstantEnum.EPretTransStatementDescription.对账确认.name());
            pretTransFeeRecord.setTransStatementId(transStatement.getId());
            pretTransFeeRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel());
            pretTransFeeRecord.setUsername(username);
            pretTransStatementRecordRepository.save(pretTransFeeRecord);
        }
    }

    /* *
     * 功能描述: 编辑对账作业
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/11/29  10:36 上午
     */
    public void editTransStatement(PretTransStatementBo bo) {
        PretTransStatement transStatement = this.repository.findById(bo.getId()).get();

        List<PretTransFee> pretTransFeeList = pretTransFeeRepository.findByTransStatementIdAndS(transStatement.getId(), ConstantEnum.S.N.getLabel());
        for (PretTransFee transFee : pretTransFeeList) {
            transFee.setTransStatementId(null);
            pretTransFeeRepository.save(transFee);
            PretTransPlan pretTransPlan = transPlanRepository.findById(transFee.getTransPlanId()).get();
            pretTransPlan.setTransStatementId(null);
            pretTransPlanRepository.save(pretTransPlan);
        }

        String[] idArr = bo.getIds().split(",");
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (String id : idArr) {
            PretTransFee transFee = transFeeRepository.findById(id).get();
            transFee.setTransStatementId(transStatement.getId());
            transFee.setStatus(ConstantEnum.EPretTransFeeStatus.审核通过.getLabel());
            transFeeRepository.save(transFee);
            totalAmount = totalAmount.add(transFee.getQuotation());

            PretTransPlan pretTransPlan = transPlanRepository.findById(transFee.getTransPlanId()).get();
            pretTransPlan.setTransStatementId(transStatement.getId());
            transPlanRepository.save(pretTransPlan);
        }

        transStatement.setTotalAmount(totalAmount);
        transStatement.setRealAmount(totalAmount);
        this.repository.save(transStatement);
    }
}
