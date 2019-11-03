package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransTrajectory;

import java.util.List;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransTrajectoryRepository extends BaseRepository<PretTransTrajectory>{
    /* *
     * 功能描述: 根据运输计划查找
     * 〈〉
     * @Param: [transPlanId, s]
            * @Return: java.util.List<com.pret.open.entity.PretTransTrajectory>
            * @Author: wujingsong
            * @Date: 2019/11/3  8:33 上午
     */
    List<PretTransTrajectory> findByTransPlanIdAndS(String transPlanId,Integer s);
}
