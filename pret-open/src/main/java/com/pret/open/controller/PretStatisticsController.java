package com.pret.open.controller;

import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.bo.PretStatisticsBo;
import com.pret.open.repository.*;
import com.pret.open.vo.req.IndexStatisticsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = {"/getPretStatistics", "/getPretStatistics/{venderId}"}, method = RequestMethod.GET)
    @ResponseBody
    public PretStatisticsBo getPretStatistics(@PathVariable(required = false) String venderId) {
        PretStatisticsBo pretStatisticsBo = new PretStatisticsBo();

        IndexStatisticsVo vo = new IndexStatisticsVo();

        // 待提货配送任务
        if (StringUtils.isEmpty(venderId)) {
            long waitingPickUpCount = pretTransOrderRepository.countByStatusAndS(ConstantEnum.ETransOrderStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
            vo.setWaitingPickUpCount(waitingPickUpCount);
        } else {
            long waitingPickUpCount = pretTransOrderRepository.countByVenderIdAndStatusAndS(venderId, ConstantEnum.ETransOrderStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
            vo.setWaitingPickUpCount(waitingPickUpCount);
        }

        // 待处理异常
        if (StringUtils.isEmpty(venderId)) {
            long waitingHandleExcepitonCount = pretTransExceptionRepository.countByStatusAndS(ConstantEnum.ECheckStatus.待审核.getLabel(), ConstantEnum.S.N.getLabel());
            vo.setWaitingHandleExcepitonCount(waitingHandleExcepitonCount);
        } else {
            long waitingHandleExcepitonCount = pretTransExceptionRepository.countByVenderIdAndStatusAndS(venderId, ConstantEnum.ECheckStatus.待审核.getLabel(), ConstantEnum.S.N.getLabel());
            vo.setWaitingHandleExcepitonCount(waitingHandleExcepitonCount);
        }

        // 在途运输业务数量
        if (StringUtils.isEmpty(venderId)) {
            long onTheWayTransCount = pretTransPlanRepository.countByStatusAndS(ConstantEnum.ETransPlanStatus.运输中.getValue(), ConstantEnum.S.N.getLabel());
            vo.setOnTheWayTransCount(onTheWayTransCount);
        } else {
            long onTheWayTransCount = pretTransPlanRepository.countByVenderIdAndStatusAndS(venderId, ConstantEnum.ETransPlanStatus.运输中.getValue(), ConstantEnum.S.N.getLabel());
            vo.setOnTheWayTransCount(onTheWayTransCount);
        }
        // 未提货完成数
        if (StringUtils.isEmpty(venderId)) {
            long unFinishPickUpCount = pretPickUpPlanRepository.countByStatusAndS(ConstantEnum.EPretPickUpPlanStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
            vo.setUnFinishPickUpCount(unFinishPickUpCount);
        } else {
            long unFinishPickUpCount = pretPickUpPlanRepository.countByVenderIdAndStatusAndS(venderId, ConstantEnum.EPretPickUpPlanStatus.待提货.getLabel(), ConstantEnum.S.N.getLabel());
            vo.setUnFinishPickUpCount(unFinishPickUpCount);
        }


        pretStatisticsBo.setIndexStatisticsVo(vo);

        return pretStatisticsBo;
    }

}