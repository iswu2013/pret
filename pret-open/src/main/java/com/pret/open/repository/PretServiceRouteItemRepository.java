package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretQuotationItem;
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
     * 功能描述: 根据serviceLineId查找
     * 〈〉
     * @Param: [serviceLineId, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/9  2:38 下午
     */
    List<PretServiceRouteItem> findByServiceRouteIdAndS(String serviceLineId, Integer s);

    /* *
     * 功能描述: 根据code,venderType，addressId和状态查询
     * 〈〉
     * @Param: [code, venderType, addressIdList, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/26  1:25 上午
     */
    List<PretServiceRouteItem> findByCodeAndVenderTypeAndAddressIdInAndS(String code, Integer venderType, List<String> addressIdList, Integer s);

    /* *
     * 功能描述: 根据id
     * 〈〉
     * @Param: [idList]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/12  2:22 上午
     */
    List<PretServiceRouteItem> findByIdInAndS(List<String> idList, Integer s);
}
