package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretRoute;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretRouteRepository extends BaseRepository<PretRoute> {
    /* *
     * 功能描述: 根据transPlanId查找
     * 〈〉
     * @Param: [transPlanId]
     * @Return: java.util.List<com.pret.open.entity.PretRoute>
     * @Author: wujingsong
     * @Date: 2019/10/22  5:58 下午
     */
    List<PretRoute> findByTransPlanId(String transPlanId);

    /* *
     * 功能描述: 根据快递单号和操作状态查找
     * 〈〉
     * @Param: [expressCode, opCode]
            * @Return: java.util.List<com.pret.open.entity.PretRoute>
            * @Author: wujingsong
            * @Date: 2019/10/22  6:02 下午
     */
    List<PretRoute> findByMailnoAndOpcode(String expressCode, String opCode);

    /* *
     * 功能描述: 根据快递单号查找
     * 〈〉
     * @Param: [expressCode]
            * @Return: java.util.List<com.pret.open.entity.PretRoute>
            * @Author: wujingsong
            * @Date: 2019/10/22  6:03 下午
     */
    List<PretRoute> findByMailno(String expressCode);

    /* *
     * 功能描述: 根据快递单号删除
     * 〈〉
     * @Param: [expressCode]
            * @Return: void
            * @Author: wujingsong
            * @Date: 2019/10/22  7:00 下午
     */
    void deleteByMailno(String expressCode);
}
