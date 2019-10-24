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
    List<PretQuotationItem> findByQuotationId(String quotationId);
}
