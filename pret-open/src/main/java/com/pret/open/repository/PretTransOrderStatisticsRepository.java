package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransOrderStatistics;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransOrderStatisticsRepository extends BaseRepository<PretTransOrderStatistics> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [userType, dateType, start, end]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrderStatistics>
     * @Author: wujingsong
     * @Date: 2019/12/3  1:34 下午
     */
    List<PretTransOrderStatistics> findByUserTypeAndDateTypeAndCreateTimeLongBetween(Integer userType, Integer dateType, long start, long end);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [userType, userId, dateType, start, end]
            * @Return: java.util.List<com.pret.open.entity.PretTransOrderStatistics>
            * @Author: wujingsong
            * @Date: 2019/12/3  1:38 下午
     */
    List<PretTransOrderStatistics> findByUserTypeAndUserIdAndDateTypeAndCreateTimeLongBetween(Integer userType, String userId, Integer dateType, long start, long end);
}