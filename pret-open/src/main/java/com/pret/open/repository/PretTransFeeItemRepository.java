package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransFeeItem;

import java.util.List;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransFeeItemRepository extends BaseRepository<PretTransFeeItem>{
    /* *
     * 功能描述: 根据transFeeId和状态查找
     * 〈〉
     * @Param: [transFeeId, s]
            * @Return: java.util.List<com.pret.open.entity.PretTransFeeItem>
            * @Author: wujingsong
            * @Date: 2019/11/28  8:54 下午
     */
    List<PretTransFeeItem> findByTransFeeIdAndS(String transFeeId,Integer s);
}
