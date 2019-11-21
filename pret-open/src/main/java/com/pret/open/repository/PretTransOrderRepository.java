package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransOrder;

import java.util.Date;
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
     * @Param: [transPlanId, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/2  11:00 上午
     */
    List<PretTransOrder> findByTransPlanIdAndS(String transPlanId, Integer s);

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

    /* *
     * 功能描述: 根据状态查找
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:20 上午
     */
    List<PretTransOrder> findByStatus(Integer status);

    /* *
     * 功能描述: 获取最前面的5个
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:30 上午
     */
    List<PretTransOrder> findTop5ByStatus(Integer status);

    /* *
     * 功能描述: 根据状态统计数量
     * 〈〉
     * @Param: [status]
     * @Return: long
     * @Author: wujingsong
     * @Date: 2019/11/4  7:20 上午
     */
    long countByStatus(Integer status);

    /* *
     * 功能描述: 根据用户，地址和送达日期以及状态查找
     * 〈〉
     * @Param: [customerId, addressId, customerAddress, deliveryDate, statusList]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/9  8:23 上午
     */
    List<PretTransOrder> findByCustomerIdAndAddressIdAndCustomerAddressAndDeliveryDateAndStatusIn(String customerId, String addressId, String customerAddress, Date deliveryDate, List<Integer> statusList);


    /* *
     * 功能描述: 根据提货计划，状态查找
     * 〈〉
     * @Param: [transPlanId, status, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/9  9:38 下午
     */
    List<PretTransOrder> findByTransPlanIdAndStatusAndS(String transPlanId, Integer status, Integer s);

    /* *
     * 功能描述: 根据u9订单号删除
     * 〈〉
     * @Param: [sourceCode]
            * @Return: com.pret.open.entity.PretTransOrder
            * @Author: wujingsong
            * @Date: 2019/11/21  12:01 下午
     */
    PretTransOrder findBySourceCode(String sourceCode);
}
