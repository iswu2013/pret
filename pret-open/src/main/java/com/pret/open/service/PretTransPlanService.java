package com.pret.open.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.constant.Constants;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.common.util.NoUtil;
import com.pret.common.util.StringUtil;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransFee;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretTransPlanVo;
import com.pret.open.repository.PretTransFeeRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransPlanRepository;
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
public class PretTransPlanService extends BaseServiceImpl<PretTransPlanRepository, PretTransPlan, PretTransPlanVo> {
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretTransPlanRepository transPlanRepository;
    @Autowired
    private PretTransFeeRepository transFeeRepository;
    @Autowired
    private PretTransFeeService transFeeService;

    /* *
     * 功能描述: 生成模板运输计划
     * 〈〉
     * @Param: [no, tail]
     * @Return: com.pret.open.entity.PretTransPlan
     * @Author: wujingsong
     * @Date: 2019/10/4  2:05 下午
     */
    public PretTransPlan genDefaultPretTransPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretTransPlan transPlan = new PretTransPlan();

        if (!StringUtils.isEmpty(no)) {
            transPlan.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretTransPlan firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                transPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.YS.name()) + tail);
            }
        }

        return transPlan;
    }

    /* *
     * 功能描述: 生成运输计划
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  2:01 下午
     */
    public void pretTransPlanAdd(PretTransPlanBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretTransPlan transPlan = this.genDefaultPretTransPlan(null, null);
        BeanUtilsExtended.copyProperties(transPlan, bo);
        PretTransOrder transOrder = null;
        String venderId=StringUtils.EMPTY;
        for (String id : idArr) {
            PretTransOrder pretTransOrder = transOrderRepository.findById(id).get();
            pretTransOrder.setTransPlanId(transPlan.getId());
            transOrderRepository.save(pretTransOrder);
            if (transOrder == null) {
                transOrder = pretTransOrder;
            }
            if (StringUtils.isEmpty(venderId)) {
                venderId = pretTransOrder.getVenderId();
            }
        }
        transPlan.setCustomerId(transOrder.getCustomerId());
        transPlan.setVenderId(venderId);
        transPlan.setStatus(ConstantEnum.ETransPlanStatus.已完成.getValue());
        this.repository.save(transPlan);
    }

    /* *
     * 功能描述: 代客签收
     * 〈〉
     * @Param: [ids]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  3:16 下午
     */
    public void sign(String ids) {
        String[] idArr = ids.split(",");
        boolean first = true;
        int sn = 0;
        for (String id : idArr) {
            PretTransPlan pretTransPlan = transPlanRepository.findById(id).get();
            pretTransPlan.setStatus(ConstantEnum.ETransPlanStatus.已签收.getValue());
            transPlanRepository.save(pretTransPlan);
            // 生成费用
            PretTransFee pretTransFee;
            if (first) {
                pretTransFee = transFeeService.genDefaultPretTransFee(null, null);
                sn = Integer.parseInt(pretTransFee.getNo().substring(19));
            } else {
                sn++;
                // 生成费用
                pretTransFee = new PretTransFee();
                String tail = StringUtil.addFrontZero(String.valueOf(sn), 6);
                pretTransFee.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TF.name()) + tail);
            }
            pretTransFee.setVenderId(pretTransPlan.getVenderId());
            pretTransFee.setCustomerId(pretTransPlan.getCustomerId());
            pretTransFee.setQuotation(new BigDecimal(100l));
            pretTransFee.setQuotationCount(1);
            pretTransFee.setStatus(ConstantEnum.EPretTransFeeStatus.待申报.getLabel());
            transFeeRepository.save(pretTransFee);
        }
    }
}
