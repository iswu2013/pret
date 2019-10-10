package com.pret.open.service;

import java.util.List;
import java.util.Optional;

import com.pret.api.vo.ResBody;
import com.pret.common.util.BeanUtilsExtended;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.PretPickUpPlanBo;
import com.pret.open.entity.vo.PretTransOrderVo;
import com.pret.open.repository.PretPickUpPlanRepository;
import com.pret.open.vo.req.*;
import com.pret.open.repository.PretTransOrderRepository;
import com.pret.api.service.impl.BaseServiceImpl;
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
public class PretTransOrderService extends BaseServiceImpl<PretTransOrderRepository, PretTransOrder, PretTransOrderVo> {
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretPickUpPlanService pretPickUpPlanService;

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

        return new ResBody();
    }
}
