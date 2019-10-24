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
     * @Param: [serviceLineId, serviceRouteOrginId, addressId, s]
     * @Return: com.pret.open.entity.PretServiceRouteItem
     * @Author: wujingsong
     * @Date: 2019/10/24  9:26 上午
     */
    PretServiceRouteItem findByServiceLineIdAndServiceRouteOrginIdAndAddressIdAndS(String serviceLineId, String serviceRouteOrginId, String addressId, int s);
    
    /* *
     * 功能描述: 根据serviceLineId查找
     * 〈〉
     * @Param: [serviceLineId]
            * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
            * @Author: wujingsong
            * @Date: 2019/10/24  9:28 上午
     */
    List<PretServiceRouteItem> findByServiceLineId(String serviceLineId);
}
