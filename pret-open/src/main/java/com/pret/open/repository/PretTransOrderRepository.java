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

    /**
     * @param pickUpPlanId
     * @param s
     * @return
     */
    List<PretTransOrder> findByPickUpPlanIdAndS(String pickUpPlanId, Integer s);

    /* *
     * 功能描述: 获取最前面的5个
     * 〈〉
     * @Param: [status]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/4  7:30 上午
     */
    List<PretTransOrder> findTop5ByStatusAndS(Integer status, Integer s);

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
            * @Date: 2019/12/3  3:51 下午
     */
    long countByVenderIdAndStatusAndS(String venderId, Integer status, Integer s);

    /* *
     * 功能描述: 根据用户，地址和送达日期以及状态查找
     * 〈〉
     * @Param: [customerId, addressId, customerAddress, start, end, statusList]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/11/27  6:32 上午
     */
    List<PretTransOrder> findByCustomerIdAndAddressIdAndCustomerAddressAndDeliveryDateBetweenAndStatusInAndS(String customerId, String addressId, String customerAddress, Date start, Date end, List<Integer> statusList, Integer s);

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
    PretTransOrder findBySourceCodeAndS(String sourceCode, Integer s);

    /* *
     * 功能描述: 根据地址和送达日期以及状态查找
     * 〈〉
     * @Param: [addressId, customerAddress, start, end, statusList, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/12/2  1:26 下午
     */
    List<PretTransOrder> findByAddressIdAndCustomerAddressAndDeliveryDateBetweenAndStatusInAndS(String addressId, String customerAddress, Date start, Date end, List<Integer> statusList, Integer s);

    /* *
     * 功能描述: 根据地址和送达日期以及状态查找
     * 〈〉
     * @Param: [addressList, start, end, statusList, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/12/3  12:37 上午
     */
    List<PretTransOrder> findByAddressIdInAndDeliveryDateBetweenAndStatusInAndS(List<String> addressList, Date start, Date end, List<Integer> statusList, Integer s);
}
