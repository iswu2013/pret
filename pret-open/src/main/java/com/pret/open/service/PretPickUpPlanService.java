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
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.vo.PretPickUpPlanVo;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretPickUpPlanRepository;
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
public class PretPickUpPlanService extends BaseServiceImpl<PretPickUpPlanRepository, PretPickUpPlan, PretPickUpPlanVo> {
    @Autowired
    private PretTransOrderRepository transOrderRepository;
    @Autowired
    private PretDriverRepository driverRepository;

    public PretPickUpPlan genDefaultPretPickUpPlan(String no, String tail) {
        Date date = DateUtils.truncate(new Date(), Calendar.DATE);
        Date endDate = DateUtils.addDays(date, 1);
        PretPickUpPlan pretPickUpPlan = new PretPickUpPlan();

        if (!StringUtils.isEmpty(no)) {
            pretPickUpPlan.setNo(no);
        } else {
            if (StringUtils.isEmpty(tail)) {
                PretPickUpPlan firstOrder = this.repository.findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(date.getTime(), endDate.getTime());
                if (firstOrder != null) {
                    String str = StringUtil.disposeFrontZero(firstOrder.getNo().substring(19));
                    int intStr = Integer.parseInt(str) + 1;
                    tail = StringUtil.addFrontZero(String.valueOf(intStr), 6);
                } else {
                    tail = Constants.TAIL;
                }
                pretPickUpPlan.setNo(NoUtil.genNo(ConstantEnum.NoTypeEnum.TH.name()) + tail);
            }
        }

        return pretPickUpPlan;
    }

    /* *
     * 功能描述: 生成提货计划
     * 〈〉
     * @Param: [bo]
     * @Return: void
     * @Author: wujingsong
     * @Date: 2019/10/4  2:03 下午
     */
    public void genPickUpPlan(PretPickUpPlanBo bo) {
        String[] idArr = bo.getIds().split(",");
        PretPickUpPlan pretPickUpPlan = this.genDefaultPretPickUpPlan(null, null);
        BeanUtilsExtended.copyProperties(pretPickUpPlan, bo);
        this.repository.save(pretPickUpPlan);
        String venderId = StringUtils.EMPTY;
        for (String id : idArr) {
            PretTransOrder pretTransOrder = transOrderRepository.findById(id).get();
            pretTransOrder.setPickUpPlanId(pretPickUpPlan.getId());
            transOrderRepository.save(pretTransOrder);
            if (StringUtils.isEmpty(venderId)) {
                venderId = pretTransOrder.getVenderId();
            }
        }
        pretPickUpPlan.setVenderId(venderId);
        this.repository.save(pretPickUpPlan);
    }

    /* *
     * 功能描述: 获取司机备货列表
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  9:55 下午
     */
    public ResBody getPickupPlanList(P8000000Vo res) {
        PretDriver pretDriver = driverRepository.findByOpenid(res.getOpenid());
        if (pretDriver != null) {
            List<PretPickUpPlan> pretPickUpPlanList = this.repository.findByDriverIdAndStatus(pretDriver.getId(), res.getStatus());
            return new ResBody().setData(pretPickUpPlanList);
        }

        return new ResBody();
    }

    /* *
     * 功能描述: 获取待备货详情
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:06 下午
     */
    public ResBody getPickupPlanDetail(P8000001Vo res) {
        PretPickUpPlan pretPickUpPlan = this.repository.findById(res.getId()).get();
        return new ResBody().setData(pretPickUpPlan);
    }

    /* *
     * 功能描述: 完成备货
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/18  10:14 下午
     */
    public ResBody finishPickupPlan(P1000001Vo res) {
        List<String> idList = StringUtil.idsStr2ListString(res.getIds());
        for (String id : idList) {
            PretPickUpPlan pickUpPlan = this.repository.findById(id).get();
            pickUpPlan.setStatus(ConstantEnum.EPretPickUpPlanStatus.已完成.getLabel());
            this.repository.save(pickUpPlan);
        }

        return new ResBody();
    }
}
