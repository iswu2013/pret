package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransOrder;
import org.springframework.data.jpa.repository.Query;

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

    List<PretTransOrder> findByAddressIdInAndTakeDeliveryDateBetweenAndDeliveryDateBetweenAndStatusInAndS(List<String> addressList, Date startT, Date endT, Date start, Date end, List<Integer> statusList, Integer s);


    List<PretTransOrder> findByAddressIdAndTakeDeliveryDateBetweenAndDeliveryDateBetweenAndStatusInAndS(String addressId, Date startT, Date endT, Date start, Date end, List<Integer> statusList, Integer s);

    List<PretTransOrder> findByAddressIdAndTakeDeliveryDateBetweenAndDeliveryDateBetweenAndStatusInAndReturnFlagAndS(String addressId, Date startT, Date endT, Date start, Date end, List<Integer> statusList, Integer returnFlag, Integer s);


    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [transGroupId, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/12/4  6:36 上午
     */
    List<PretTransOrder> findByTransOrderGroupIdAndS(String transGroupId, Integer s);

    @Query("select sum (kilo) from PretTransOrder where transOrderGroupId=?1 ")
    Float sumKiloByTransOrderGroupId(String transOrderGroupId);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [idList, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/12/11  9:19 上午
     */
    List<PretTransOrder> findByIdInAndS(List<String> idList, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [groupId, s]
     * @Return: com.pret.open.entity.PretTransOrder
     * @Author: wujingsong
     * @Date: 2019/12/16  10:23 上午
     */
    PretTransOrder findTop1ByTransOrderGroupIdAndS(String groupId, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [deliveryBillNumber, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
     * @Author: wujingsong
     * @Date: 2019/12/17  7:47 上午
     */
    List<PretTransOrder> findByDeliveryBillNumberAndS(String deliveryBillNumber, Integer s);

    /* *
     * 功能描述: 根据mailno查找
     * 〈〉
     * @Param: [mailno]
     * @Return: com.pret.open.entity.PretTransOrder
     * @Author: wujingsong
     * @Date: 2019/12/19  7:46 下午
     */
    PretTransOrder findTop1ByMailno(String mailno);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [mailno, s]
     * @Return: com.pret.open.entity.PretTransOrder
     * @Author: wujingsong
     * @Date: 2019/12/19  9:51 下午
     */
    PretTransOrder findTop1ByMailnoAndStatus(String mailno, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [mailno]
            * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
            * @Author: wujingsong
            * @Date: 2019/12/22  11:36 下午
     */
    List<PretTransOrder> findByMailno(String mailno);
    
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [idList]
            * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
            * @Author: wujingsong
            * @Date: 2019/12/22  11:38 下午
     */
    List<PretTransOrder> findByTransOrderGroupIdIn(List<String> idList);
    
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [pickUpIdList, s]
            * @Return: java.util.List<com.pret.open.entity.PretTransOrder>
            * @Author: wujingsong
            * @Date: 2019/12/29  6:02 上午
     */
    List<PretTransOrder> findByPickUpPlanIdInAndS(List<String> pickUpIdList,Integer s);
}
