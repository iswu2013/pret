package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretPickUpPlan;

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
}
