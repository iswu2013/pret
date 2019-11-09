package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretGoods;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretGoodsRepository extends BaseRepository<PretGoods>{
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [partNo, batchNo, product]
            * @Return: com.pret.open.entity.PretGoods
            * @Author: wujingsong
            * @Date: 2019/11/9  6:37 下午
     */
    PretGoods findByPartNoAndBatchNoAndProduct(String partNo,String batchNo,String product);
}
