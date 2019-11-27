package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransStatement;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransStatementRepository extends BaseRepository<PretTransStatement> {
    /* *
     * 功能描述: 查找最近的订单
     * 〈〉
     * @Param: [time, time1]
     * @Return: com.pret.open.entity.PretTransStatement
     * @Author: wujingsong
     * @Date: 2019/10/4  5:39 下午
     */
    PretTransStatement findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(long time, long time1);
}
