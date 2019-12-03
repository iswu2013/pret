package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretTransOrder;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretPickUpPlanRepository extends BaseRepository<PretPickUpPlan> {
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
     * 功能描述: 根据driverId和实际到场时间不为Null查找
     * 〈〉
     * @Param: [driverId]
     * @Return: java.util.List<com.pret.open.entity.PretPickUpPlan>
     * @Author: wujingsong
     * @Date: 2019/10/18  11:10 下午
     */
    List<PretPickUpPlan> findByDriverIdAndSAndStartTimeIsNull(String driverId, Integer s);

    /* *
     * 功能描述: 根据driverId和实际到场时间不为Null查找
     * 〈〉
     * @Param: [driverId]
     * @Return: java.util.List<com.pret.open.entity.PretPickUpPlan>
     * @Author: wujingsong
     * @Date: 2019/10/18  11:13 下午
     */
    List<PretPickUpPlan> findByDriverIdAndSAndStartTimeIsNotNullAndEndTimeIsNull(String driverId, Integer s);

    /* *
     * 功能描述: 获取最前面的5个
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:30 上午
     */
    List<PretPickUpPlan> findTop5ByStatusAndS(Integer status, Integer s);

    /* *
     * 功能描述: 根据状态统计数量
     * 〈〉
     * @Param: [status]
     * @Return: long
     * @Author: wujingsong
     * @Date: 2019/11/4  7:20 上午
     */
    long countByStatusAndS(Integer status, Integer s);

    /* *
     * 功能描述: 根据venderId和状态查询
     * 〈〉
     * @Param: [status, s]
     * @Return: long
     * @Author: wujingsong
     * @Date: 2019/12/3  3:52 下午
     */
    long countByVenderIdAndStatusAndS(String venderId, Integer status, Integer s);
}
