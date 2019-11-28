package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretQuotationItem;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretQuotationItemRepository extends BaseRepository<PretQuotationItem> {
    /* *
     * 功能描述: 根据quotationId查找
     * 〈〉
     * @Param: [quotationId]
     * @Return: java.util.List<com.pret.open.entity.PretQuotationItem>
     * @Author: wujingsong
     * @Date: 2019/10/24  10:57 上午
     */
    List<PretQuotationItem> findByQuotationIdAndS(String quotationId, Integer s);


    /* *
     * 功能描述: 根据服务线路明细查找
     * 〈〉
     * @Param: [serviceRouteItemId, s]
     * @Return: java.util.List<com.pret.open.entity.PretQuotationItem>
     * @Author: wujingsong
     * @Date: 2019/11/8  10:22 上午
     */
    List<PretQuotationItem> findByServiceRouteItemIdAndS(String serviceRouteItemId, String s);

    /* *
     * 功能描述: 根据供应商和状态查找
     * 〈〉
     * @Param: [venderId, s]
     * @Return: java.util.List<com.pret.open.entity.PretQuotationItem>
     * @Author: wujingsong
     * @Date: 2019/11/9  8:36 上午
     */
    List<PretQuotationItem> findByVenderIdAndS(String venderId, Integer s);

    /* *
     * 功能描述: 根据供应商，服务线路id和状态查询
     * 〈〉
     * @Param: [venderId, serviceRouteItemId, s]
     * @Return: java.util.List<com.pret.open.entity.PretQuotationItem>
     * @Author: wujingsong
     * @Date: 2019/11/28  9:42 上午
     */
    List<PretQuotationItem> findByVenderIdAndServiceRouteItemIdAndS(String venderId, String serviceRouteItemId, Integer s);
}
