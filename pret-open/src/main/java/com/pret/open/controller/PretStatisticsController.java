package com.pret.open.controller;

import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretStatisticsBo;
import com.pret.open.repository.*;
import com.pret.open.vo.req.IndexStatisticsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 统计管理
 */
@Slf4j
@Validated
@RestController
@RequestMapping("statistics")
public class PretStatisticsController {
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretTransExceptionRepository pretTransExceptionRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretPickUpPlanRepository pretPickUpPlanRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;

    @RequestMapping(value = "/getPretStatistics", method = RequestMethod.GET)
    @ResponseBody
    public PretStatisticsBo getPretStatistics() {
        PretStatisticsBo pretStatisticsBo = new PretStatisticsBo();

        IndexStatisticsVo vo = new IndexStatisticsVo();

        // 待提货配送任务
        long waitingPickUpCount = pretTransOrderRepository.countByStatusAndS(ConstantEnum.ETransOrderStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
        vo.setWaitingPickUpCount(waitingPickUpCount);
        // 待处理异常
        long waitingHandleExcepitonCount = pretTransExceptionRepository.countByStatusAndS(ConstantEnum.ECheckStatus.待审核.getLabel(), ConstantEnum.S.N.getLabel());
        vo.setWaitingHandleExcepitonCount(waitingHandleExcepitonCount);
        // 在途运输业务数量
        long onTheWayTransCount = pretTransPlanRepository.countByStatusAndS(ConstantEnum.ETransPlanStatus.运输中.getValue(), ConstantEnum.S.N.getLabel());
        vo.setOnTheWayTransCount(onTheWayTransCount);
        // 未提货完成数
        long unFinishPickUpCount = pretPickUpPlanRepository.countByStatusAndS(ConstantEnum.EPretPickUpPlanStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
        vo.setUnFinishPickUpCount(unFinishPickUpCount);

        List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findTop5ByStatusAndS(ConstantEnum.ETransOrderStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
        for (PretTransOrder pretTransOrder : pretTransOrderList) {
            if (!StringUtils.isEmpty(pretTransOrder.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretTransOrder.getVenderId()).get();
                pretTransOrder.setPretVender(pretVender);
            }
        }
        pretStatisticsBo.setWaitingPickUpList(pretTransOrderList);

        List<PretTransException> pretTransExceptionList = pretTransExceptionRepository.findTop5ByStatusAndS(ConstantEnum.ECheckStatus.待审核.getLabel(), ConstantEnum.S.N.getLabel());
        pretStatisticsBo.setWaitingHandleExcepitonList(pretTransExceptionList);
        for (PretTransException pretTransException : pretTransExceptionList) {
            if (!StringUtils.isEmpty(pretTransException.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretTransException.getVenderId()).get();
                pretTransException.setPretVender(pretVender);
            }
        }

        List<PretTransPlan> pretTransPlanList = pretTransPlanRepository.findTop5ByStatusAndS(ConstantEnum.ETransPlanStatus.运输中.getValue(), ConstantEnum.S.N.getLabel());
        pretStatisticsBo.setOnTheWayTransList(pretTransPlanList);
        for (PretTransPlan pretTransPlan : pretTransPlanList) {
            if (!StringUtils.isEmpty(pretTransPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretTransPlan.getVenderId()).get();
                pretTransPlan.setPretVender(pretVender);
            }
        }

        List<PretPickUpPlan> pretPickUpPlanList = pretPickUpPlanRepository.findTop5ByStatusAndS(ConstantEnum.EPretPickUpPlanStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
        pretStatisticsBo.setUnFinishPickUpList(pretPickUpPlanList);
        for (PretPickUpPlan pretPickUpPlan : pretPickUpPlanList) {
            if (!StringUtils.isEmpty(pretPickUpPlan.getVenderId())) {
                PretVender pretVender = pretVenderRepository.findById(pretPickUpPlan.getVenderId()).get();
                pretPickUpPlan.setPretVender(pretVender);
            }
        }

        pretStatisticsBo.setIndexStatisticsVo(vo);

        return pretStatisticsBo;
    }

}