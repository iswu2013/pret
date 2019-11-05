package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransException;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransPlan;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransPlanRepository extends BaseRepository<PretTransPlan> {
    PretTransPlan findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(long time, long time1);

    /* *
     * 功能描述: 根据状态查找
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransPlan>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:20 上午
     */
    List<PretTransPlan> findByStatus(Integer status);

    /* *
     * 功能描述: 获取最前面的5个
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransPlan>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:30 上午
     */
    List<PretTransPlan> findTop5ByStatus(Integer status);

    /* *
     * 功能描述: 根据状态统计数量
     * 〈〉
     * @Param: [status]
     * @Return: long
     * @Author: wujingsong
     * @Date: 2019/11/4  7:20 上午
     */
    long countByStatus(Integer status);
}
