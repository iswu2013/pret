package com.pret.open.repository.user;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.user.Role;

/**
 * <p>Description: [tRepository]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface RoleRepository extends BaseRepository<Role> {
    /* *
     * 功能描述: 根据code查找
     * 〈〉
     * @Param: [code]
     * @Return: com.pret.open.entity.user.Role
     * @Author: wujingsong
     * @Date: 2019/11/4  10:49 上午
     */
    Role findByCode(String code);

    /* *
     * 功能描述: 根据roleId查找
     * 〈〉
     * @Param: [roleId]
     * @Return: com.pret.open.entity.user.Role
     * @Author: wujingsong
     * @Date: 2019/11/5  9:08 上午
     */
    Role findByRoleId(Long roleId);
}
