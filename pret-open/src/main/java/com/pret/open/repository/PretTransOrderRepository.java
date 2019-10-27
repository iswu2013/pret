package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
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
public interface PretTransOrderRepository extends BaseRepository<PretTransOrder> {
    /* *
     * 功能描述: 根据运输计划查找
     * 〈〉
     * @Param: [transPlanId]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/10/4  7:09 上午
     */
    List<PretTransOrder> findByTransPlanId(String transPlanId);

    /* *
     * 功能描述: 根据提货计划查找
     * 〈〉
     * @Param: [pickUpPlanId]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/10/4  7:10 上午
     */
    List<PretTransOrder> findByPickUpPlanId(String pickUpPlanId);

    /* *
     * 功能描述: 根据transPlanId查找
     * 〈〉
     * @Param: [transPlanId]
     * @Return: com.pret.open.entity.PretTransOrder
     * @Author: wujingsong
     * @Date: 2019/10/19  8:32 上午
     */
    PretTransOrder findTop1ByTransPlanId(String transPlanId);

    /* *
     * 功能描述: 根据transStatementId
     * 〈〉
     * @Param: [transStatementId]
            * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
            * @Author: wujingsong
            * @Date: 2019/10/27  5:51 下午
     */
    List<PretTransOrder> findByTransStatementId(String transStatementId);
}
