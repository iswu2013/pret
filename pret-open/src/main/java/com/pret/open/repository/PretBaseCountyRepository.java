package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretBaseCounty;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年11月30日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretBaseCountyRepository extends BaseRepository<PretBaseCounty> {
    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [city]
            * @Return: java.util.List<com.pret.open.entity.PretBaseCounty>
            * @Author: wujingsong
            * @Date: 2019/11/30  7:45 下午
     */
    List<PretBaseCounty> findByCity(String city);
}
