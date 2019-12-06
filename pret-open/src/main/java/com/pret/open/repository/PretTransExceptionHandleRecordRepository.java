package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransExceptionHandleRecord;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransExceptionHandleRecordRepository extends BaseRepository<PretTransExceptionHandleRecord> {
    
    /* *
     * 功能描述: 根据异常id和状态查找
     * 〈〉
     * @Param: [exceptionId, s]
            * @Return: java.util.List<com.pret.open.entity.PretTransExceptionHandleRecord>
            * @Author: wujingsong
            * @Date: 2019/11/25  5:02 上午
     */
    List<PretTransExceptionHandleRecord> findByExceptionIdAndS(String exceptionId,Integer s);

    List<PretTransExceptionHandleRecord> findByExceptionIdAndSOrderByLastModifiedDateDesc(String exceptionId,Integer s);
}
