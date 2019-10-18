package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretDriver;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretDriverRepository extends BaseRepository<PretDriver>{
    /* *
     * 功能描述: 根据openid查找
     * 〈〉
     * @Param: [openid]
            * @Return: com.pret.open.entity.PretDriver
            * @Author: wujingsong
            * @Date: 2019/10/18  9:56 下午
     */
    PretDriver findByOpenid(String openid);
}
