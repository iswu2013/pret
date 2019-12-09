package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretPickUpRecord;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretPickUpRecordRepository extends BaseRepository<PretPickUpRecord> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [pickUpPlanId, s]
            * @Return: java.util.List<com.pret.open.entity.PretPickUpRecord>
            * @Author: wujingsong
            * @Date: 2019/12/9  10:41 下午
     */
    List<PretPickUpRecord> findByPickUpPlanIdAndS(String pickUpPlanId,Integer s);
}
