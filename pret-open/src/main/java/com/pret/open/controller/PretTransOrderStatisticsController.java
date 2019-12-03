package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.util.DateUtil;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransOrderStatistics;
import com.pret.open.entity.bo.PretTransOrderStatisticsBo;
import com.pret.open.entity.vo.PretTransOrderStatisticsVo;
import com.pret.open.repository.PretTransOrderStatisticsRepository;
import com.pret.open.service.PretTransOrderStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("pretTransOrderStatistics")
public class PretTransOrderStatisticsController extends BaseManageController<PretTransOrderStatisticsService, PretTransOrderStatistics, PretTransOrderStatisticsVo> {
    @Autowired
    private PretTransOrderStatisticsRepository pretTransOrderStatisticsRepository;

    @Log("查看")
    @GetMapping(value = {"/stat/{start}/{end}/{venderId}", "/stat/{start}/{end}"})
    public PretTransOrderStatisticsBo getTransOrderStatistics(@PathVariable long start, @PathVariable long end, @PathVariable(required = false) String venderId) throws FebsException {
        PretTransOrderStatisticsBo bo = new PretTransOrderStatisticsBo();

        try {
            if (StringUtils.isEmpty(venderId)) {
                List<PretTransOrderStatistics> pretTransOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), ConstantEnum.EDateType.日.getLabel(), start, end);
                bo.setPretTransOrderStatisticsList(pretTransOrderStatisticsList);
                Date startDate = DateUtils.truncate(new Date(), Calendar.DATE);
                Date dateEnd = DateUtils.addDays(startDate, 1);

                // 日统计
                List<PretTransOrderStatistics> transOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), ConstantEnum.EDateType.日.getLabel(),
                        startDate.getTime(), dateEnd.getTime());
                if (transOrderStatisticsList != null && transOrderStatisticsList.size() == 1) {
                    bo.setTodayCount(transOrderStatisticsList.get(0).getCount());
                }

                // 月统计
                startDate = DateUtil.getBeginDayOfMonth();
                transOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), ConstantEnum.EDateType.月.getLabel(),
                        startDate.getTime(), dateEnd.getTime());
                if (transOrderStatisticsList != null && transOrderStatisticsList.size() == 1) {
                    bo.setThisMonthCount(transOrderStatisticsList.get(0).getCount());
                }
                // 年
                startDate = DateUtil.getBeginDayOfYear();
                transOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), ConstantEnum.EDateType.年.getLabel(),
                        startDate.getTime(), dateEnd.getTime());
                if (transOrderStatisticsList != null && transOrderStatisticsList.size() == 1) {
                    bo.setTotalCount(transOrderStatisticsList.get(0).getCount());
                }
            } else {
                List<PretTransOrderStatistics> pretTransOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndUserIdAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.平台.getLabel(), venderId, ConstantEnum.EDateType.日.getLabel(), start, end);
                bo.setPretTransOrderStatisticsList(pretTransOrderStatisticsList);

                Date startDate = DateUtils.truncate(new Date(), Calendar.DATE);
                Date dateEnd = DateUtils.addDays(startDate, 1);

                // 日统计
                List<PretTransOrderStatistics> transOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndUserIdAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), venderId, ConstantEnum.EDateType.日.getLabel(),
                        startDate.getTime(), dateEnd.getTime());
                if (transOrderStatisticsList != null && transOrderStatisticsList.size() == 1) {
                    bo.setTodayCount(transOrderStatisticsList.get(0).getCount());
                }

                // 月统计
                startDate = DateUtil.getBeginDayOfMonth();
                transOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndUserIdAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), venderId, ConstantEnum.EDateType.月.getLabel(),
                        startDate.getTime(), dateEnd.getTime());
                if (transOrderStatisticsList != null && transOrderStatisticsList.size() == 1) {
                    bo.setThisMonthCount(transOrderStatisticsList.get(0).getCount());
                }
                // 年
                startDate = DateUtil.getBeginDayOfYear();
                transOrderStatisticsList = pretTransOrderStatisticsRepository.findByUserTypeAndUserIdAndDateTypeAndCreateTimeLongBetween(ConstantEnum.ETransOrderStatisticsUserType.物流供应商.getLabel(), venderId, ConstantEnum.EDateType.年.getLabel(),
                        startDate.getTime(), dateEnd.getTime());
                if (transOrderStatisticsList != null && transOrderStatisticsList.size() == 1) {
                    bo.setTotalCount(transOrderStatisticsList.get(0).getCount());
                }
            }
            return bo;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }
}