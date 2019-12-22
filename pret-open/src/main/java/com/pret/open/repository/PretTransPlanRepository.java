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
    PretTransPlan findTop1ByTypeAndCreateTimeLongBetweenOrderByCreateTimeLongDesc(Integer type, long time, long time1);

    /* *
     * 功能描述: 根据状态查找
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransPlan>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:20 上午
     */
    List<PretTransPlan> findByStatusAndS(Integer status, Integer s);

    /* *
     * 功能描述: 获取最前面的5个
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransPlan>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:30 上午
     */
    List<PretTransPlan> findTop5ByStatusAndS(Integer status, Integer s);

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
     * @Param: [venderId, status, s]
     * @Return: long
     * @Author: wujingsong
     * @Date: 2019/12/3  3:52 下午
     */
    long countByVenderIdAndStatusAndS(String venderId, Integer status, Integer s);

    /* *
     * 功能描述: 根据对账单Id和状态查询
     * 〈〉
     * @Param: [transStatementId, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransPlan>
     * @Author: wujingsong
     * @Date: 2019/11/20  5:31 下午
     */
    List<PretTransPlan> findByTransStatementIdAndS(String transStatementId, Integer s);

    /* *
     * 功能描述: 根据venderId和状态查找
     * 〈〉
     * @Param: [venderId, status]
            * @Return: java.util.List<com.pret.open.entity.PretTransPlan>
            * @Author: wujingsong
            * @Date: 2019/12/10  9:58 上午
     */
    List<PretTransPlan> findByVenderIdAndStatus(String venderId,Integer status);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [mailno]
            * @Return: com.pret.open.entity.PretTransPlan
            * @Author: wujingsong
            * @Date: 2019/12/22  9:57 下午
     */
    PretTransPlan findByMailno(String mailno);
}
