package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretPickUpPlan;

import java.util.List;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretPickUpPlanRepository extends BaseRepository<PretPickUpPlan>{
    /* *
     * 功能描述: 查找最近的计划
     * 〈〉
     * @Param: [time, time1]
            * @Return: com.pret.open.entity.PretPickUpPlan
            * @Author: wujingsong
            * @Date: 2019/10/2  8:46 下午
     */
    PretPickUpPlan findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(long time, long time1);

    /* *
     * 功能描述: 根据司机id和状态查询
     * 〈〉
     * @Param: [driverId, status]
            * @Return: java.util.List<com.pret.open.entity.PretPickUpPlan>
            * @Author: wujingsong
            * @Date: 2019/10/18  9:58 下午
     */
    List<PretPickUpPlan> findByDriverIdAndStatus(String driverId,Integer status);
}
