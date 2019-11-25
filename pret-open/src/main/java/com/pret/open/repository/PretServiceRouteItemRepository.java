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
     * 功能描述: 根据serviceLineId, serviceRouteOriginId, addressId, s查找
     * 〈〉
     * @Param: [serviceRouteId, serviceRouteOriginId, addressId, s]
     * @Return: com.pret.open.entity.PretServiceRouteItem
     * @Author: wujingsong
     * @Date: 2019/10/24  9:26 上午
     */
    PretServiceRouteItem findByServiceRouteIdAndServiceRouteOriginIdAndAddressIdAndS(String serviceRouteId, String serviceRouteOriginId, String addressId, int s);

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
     * 功能描述: 根据起运地和地址查找
     * 〈〉
     * @Param: [serviceRouteOriginId, addressId, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/8  10:14 上午
     */
    List<PretServiceRouteItem> findByServiceRouteOriginIdAndAddressIdAndS(String serviceRouteOriginId, String addressId, Integer s);


    /* *
     * 功能描述: 根据code查找
     * 〈〉
     * @Param: [code, addressId, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/8  10:17 上午
     */
    List<PretServiceRouteItem> findByCodeAndAddressIdAndS(String code, String addressId, Integer s);

    /* *
     * 功能描述: 根据code或者addreddId查找
     * 〈〉
     * @Param: [code, addressIdList, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/9  11:01 上午
     */
    List<PretServiceRouteItem> findByCodeAndAddressIdInAndS(String code, List<String> addressIdList, Integer s);


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
     * 功能描述: 查找没有关联的线路
     * 〈〉
     * @Param: [s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/11  10:06 下午
     */
    List<PretServiceRouteItem> findBySAndVenderIdIsNull(Integer s);

    /* *
     * 功能描述: venderId
     * 〈〉
     * @Param: [s, venderId]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/11  10:13 下午
     */
    List<PretServiceRouteItem> findBySAndVenderIdIsNullOrVenderId(Integer s, String venderId);

    /* *
     * 功能描述: 根据id
     * 〈〉
     * @Param: [idList]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/12  2:22 上午
     */
    List<PretServiceRouteItem> findByIdIn(List<String> idList);

    /* *
     * 功能描述: 根据供应商和状态查询
     * 〈〉
     * @Param: [venderId, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteItem>
     * @Author: wujingsong
     * @Date: 2019/11/25  2:29 下午
     */
    List<PretServiceRouteItem> findByVenderIdAndS(String venderId, Integer s);
}
