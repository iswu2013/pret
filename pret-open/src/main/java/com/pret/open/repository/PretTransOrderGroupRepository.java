package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.PretTransOrderGroup;

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
public interface PretTransOrderGroupRepository extends BaseRepository<PretTransOrderGroup> {
    /* *
     * 功能描述: 根据送货单号查找
     * 〈〉
     * @Param: [deliveryBillNumber, s]
     * @Return: com.pret.open.entity.PretTransOrderGroup
     * @Author: wujingsong
     * @Date: 2019/12/4  5:43 上午
     */
    PretTransOrderGroup findByDeliveryBillNumberAndS(String deliveryBillNumber, Integer s);

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [sourceCode, s]
            * @Return: com.pret.open.entity.PretTransOrderGroup
            * @Author: wujingsong
            * @Date: 2019/12/16  10:28 上午
     */
    PretTransOrderGroup findBySourceCodeAndS(String sourceCode,Integer s);
}
