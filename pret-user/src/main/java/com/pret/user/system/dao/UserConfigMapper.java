package com.pret.user.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pret.user.system.domain.UserConfig;

public interface UserConfigMapper extends BaseMapper<UserConfig> {
    /* *
     * 功能描述: 根据userId查找
     * 〈〉
     * @Param: [userId]
            * @Return: com.pluto.user.system.domain.UserConfig
            * @Author: wujingsong
            * @Date: 2019/11/6  5:27 下午
     */
    UserConfig findByUserId(String userId);

    /* *
     * 功能描述: 根据userId更新
     * 〈〉
     * @Param: [userConfig]
            * @Return: void
            * @Author: wujingsong
            * @Date: 2019/11/6  5:45 下午
     */
    void updateByUserId(UserConfig userConfig);
}