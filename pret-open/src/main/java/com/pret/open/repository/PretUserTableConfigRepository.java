package com.pret.open.repository;


import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.PretUserTableConfig;

/**
 * <p>Description: 表格配置</p>
 * Created on 2019年10月03日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface PretUserTableConfigRepository extends BaseRepository<PretUserTableConfig> {
    /* *
     * 功能描述: 根据用户id和模块id查找
     * 〈〉
     * @Param: [userId, module]
     * @Return: com.pluto.api.entity.UserTableConfig
     * @Author: wujingsong
     * @Date: 2019/10/30  6:56 下午
     */
    PretUserTableConfig findByUserIdAndModule(String userId, String module);
}
