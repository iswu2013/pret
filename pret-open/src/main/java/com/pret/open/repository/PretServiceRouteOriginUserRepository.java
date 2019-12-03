package com.pret.open.repository;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretFeeType;
import com.pret.open.entity.PretServiceRouteOriginUser;

import java.util.List;

/**
 * <p>Description: [pretRepository]</p>
 * Created on 2019年10月25日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretServiceRouteOriginUserRepository extends BaseRepository<PretServiceRouteOriginUser> {
    /* *
     * 功能描述: 根据供应商查找
     * 〈〉
     * @Param: [venderId, s]
     * @Return: java.util.List<com.pret.open.entity.PretServiceRouteOriginUser>
     * @Author: wujingsong
     * @Date: 2019/12/3  11:05 上午
     */
    List<PretServiceRouteOriginUser> findByVenderIdAndS(String venderId, Integer s);
}
