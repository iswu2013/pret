package com.pret.open.service;

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
import com.pret.open.entity.PretTransException;
import com.pret.open.entity.PretTransPlan;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransExceptionBo;
import com.pret.open.entity.vo.PretTransExceptionVo;
import com.pret.open.repository.PretTransPlanRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransExceptionRepository;
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
public class PretTransExceptionService extends BaseServiceImpl<PretTransExceptionRepository, PretTransException, PretTransExceptionVo> {
    @Autowired
    private PretTransPlanRepository transPlanRepository;

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
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                transException.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TH.name()) + tail);
            }
        }

        return transException;
    }

    /* *
     * 功能描述: 生产运输异常
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/19  8:07 上午
     */
    public void genPretTransException(PretTransExceptionBo bo) {
        PretTransException pretTransException = this.genDefaultPretTransException(null, null);
        PretTransPlan pretTransPlan = transPlanRepository.findById(bo.getTransPlanId()).get();
        pretTransException.setVenderId(pretTransPlan.getVenderId());

        BeanUtilsExtended.copyProperties(pretTransException, bo);
        this.repository.save(pretTransException);
    }
}
