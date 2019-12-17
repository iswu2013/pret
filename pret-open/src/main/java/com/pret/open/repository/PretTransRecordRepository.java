package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretAddress;
import com.pret.open.entity.PretTransRecord;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransRecordRepository extends BaseRepository<PretTransRecord> {
    /* *
     * 功能描述: 根据transPlanId和状态查找
     * 〈〉
     * @Param: [transPlanId, s]
     * @Return: java.util.List<com.pret.open.entity.PretTransRecord>
     * @Author: wujingsong
     * @Date: 2019/12/9  10:16 下午
     */
    List<PretTransRecord> findByTransPlanIdAndS(String transPlanId, Integer s);

    List<PretTransRecord> findByTransPlanIdAndSOrderByLastModifiedDateDesc(String transPlanId, Integer s);
}
