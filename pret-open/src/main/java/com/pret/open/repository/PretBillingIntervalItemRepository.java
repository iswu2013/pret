package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretBillingIntervalItem;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretBillingIntervalItemRepository extends BaseRepository<PretBillingIntervalItem> {
    /* *
     * 功能描述: 根据billingIntervalId查找
     * 〈〉
     * @Param: [billingIntervalId, s]
            * @Return: java.util.List<com.pret.open.entity.PretBillingIntervalItem>
            * @Author: wujingsong
            * @Date: 2019/11/2  1:28 上午
     */
    List<PretBillingIntervalItem> findByBillingIntervalIdAndS(String billingIntervalId,Integer s);
}
