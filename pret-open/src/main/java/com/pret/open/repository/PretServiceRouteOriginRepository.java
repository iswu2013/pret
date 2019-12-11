package com.pret.open.repository;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretServiceRouteOrigin;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretServiceRouteOriginRepository extends BaseRepository<PretServiceRouteOrigin> {
    /* *
     * 功能描述: 根据code查询
     * 〈〉
     * @Param: [code, s]
     * @Return: com.pret.open.entity.PretServiceRouteOrigin
     * @Author: wujingsong
     * @Date: 2019/11/27  11:57 上午
     */
    PretServiceRouteOrigin findByCodeAndS(String code, Integer s);

    List<PretServiceRouteOrigin> findByS(Integer s);
}
