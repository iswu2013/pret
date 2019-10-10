package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretTransException;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretTransExceptionRepository extends BaseRepository<PretTransException>{
    
    /* *
     * 功能描述: 查找最近的
     * 〈〉
     * @Param: [time, time1]
            * @Return: com.pret.open.entity.PretTransException
            * @Author: wujingsong
            * @Date: 2019/10/4  10:34 下午
     */
    PretTransException findTop1ByCreateTimeLongBetweenOrderByCreateTimeLongDesc(long time, long time1);
}
