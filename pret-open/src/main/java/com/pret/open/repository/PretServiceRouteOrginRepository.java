package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretServiceRouteOrgin;

import java.util.List;

/** 
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public interface PretServiceRouteOrginRepository extends BaseRepository<PretServiceRouteOrgin>{
    /* *
     * 功能描述: 根据id查询
     * 〈〉
     * @Param: [idList]
            * @Return: java.util.List<com.pret.open.entity.PretServiceRouteOrgin>
            * @Author: wujingsong
            * @Date: 2019/10/18  1:13 下午
     */
    List<PretServiceRouteOrgin> findByIdIn(List<String> idList);
}
