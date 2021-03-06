package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransFee;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransFeeRepository extends BaseRepository<PretTransFee> {
    /* *
     * 功能描述: 查找最新的费用单
     * 〈〉
     * @Param: [time, time1]
     * @Return: com.pret.open.entity.PretTransFee
     * @Author: wujingsong
     * @Date: 2019/10/4  5:17 下午
     */
    PretTransFee findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(long time, long time1);

    /* *
     * 功能描述: 根据id查询
     * 〈〉
     * @Param: [idList]
     * @Return: java.util.List<com.pret.open.entity.PretTransFee>
     * @Author: wujingsong
     * @Date: 2019/11/27  11:58 下午
     */
    List<PretTransFee> findByIdIn(List<String> idList);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [statementId, s]
            * @Return: java.util.List<com.pret.open.entity.PretTransFee>
            * @Author: wujingsong
            * @Date: 2019/11/29  9:21 上午
     */
    List<PretTransFee> findByTransStatementIdAndS(String statementId,Integer s);
    
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [transPlanId, s]
            * @Return: com.pret.open.entity.PretTransFee
            * @Author: wujingsong
            * @Date: 2019/12/15  9:42 下午
     */
    PretTransFee findByTransPlanIdAndS(String transPlanId,Integer s);
}
