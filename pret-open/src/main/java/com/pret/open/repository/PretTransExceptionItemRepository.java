package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransExceptionItem;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransExceptionItemRepository extends BaseRepository<PretTransExceptionItem> {
    /* *
     * 功能描述: 根据异常查找明细
     * 〈〉
     * @Param: [transExceptionId]
     * @Return: java.util.List<com.pret.open.entity.PretTransExceptionItem>
     * @Author: wujingsong
     * @Date: 2019/11/6  1:40 下午
     */
    List<PretTransExceptionItem> findByTransExceptionId(String transExceptionId);
}
