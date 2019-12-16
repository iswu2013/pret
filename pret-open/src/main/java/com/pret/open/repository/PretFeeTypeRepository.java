package com.pret.open.repository;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretFeeType;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年10月25日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretFeeTypeRepository extends BaseRepository<PretFeeType> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [name, s]
            * @Return: com.pret.open.entity.PretFeeType
            * @Author: wujingsong
            * @Date: 2019/12/16  7:44 下午
     */
    PretFeeType findByNameAndS(String name,Integer s);
}
