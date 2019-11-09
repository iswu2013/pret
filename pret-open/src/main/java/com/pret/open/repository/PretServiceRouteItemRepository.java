package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretServiceRouteItem;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretServiceRouteItemRepository extends BaseRepository<PretServiceRouteItem> {
    /* *
     * 功能描述: 根据serviceLineId, serviceRouteOrginId, addressId, s查找
     * 〈〉
     * @Param: [serviceRouteId, serviceRouteOrginId, addressId, s]
     * @Return: com.pret.open.entity.PretServiceRouteItem
     * @Author: wujingsong
     * @Date: 2019/10/24  9:26 上午
     */
    PretServiceRouteItem findByServiceRouteIdAndServiceRouteOrginIdAndAddressIdAndS(String serviceRouteId, String serviceRouteOrginId, String addressId, int s);

    /* *
     * 功能描述: 根据serviceLineId查找
     * 〈〉
     * @Param: [serviceRouteId]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/10/24  9:28 上午
     */
    List<PretServiceRouteItem> findByServiceRouteId(String serviceLineId);

    /* *
     * 功能描述: 根据起运地和地址查找
     * 〈〉
     * @Param: [serviceRouteOrginId, addressId, s]
            * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
            * @Author: wujingsong
            * @Date: 2019/11/8  10:14 上午
     */
    List<PretServiceRouteItem> findByServiceRouteOrginIdAndAddressIdAndS(String serviceRouteOrginId, String addressId,Integer s);

    /* *
     * 功能描述: 根据code查找
     * 〈〉
     * @Param: [code, addressId, s]
            * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
            * @Author: wujingsong
            * @Date: 2019/11/8  10:17 上午
     */
    List<PretServiceRouteItem> findByCodeAndAddressIdAndS(String code, String addressId,Integer s);
}
