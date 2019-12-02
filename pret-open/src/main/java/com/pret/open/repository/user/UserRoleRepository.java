package com.pret.open.repository.user;

import com.pret.common.repository.BaseRepository;
import com.pret.open.entity.user.UserRole;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * <p>Description: [tRepository]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public interface UserRoleRepository extends BaseRepository<UserRole> {
    /* *
     * 功能描述: 根据用户id查找
     * 〈〉
     * @Param: [id]
     * @Return: com.pret.open.entity.user.UserRole
     * @Author: wujingsong
     * @Date: 2019/10/20  9:08 下午
     */
    UserRole findById(Long id);

    /* *
     * 功能描述: 根据角色和状态查询
     * 〈〉
     * @Param: [roleId]
     * @Return: java.util.List<com.pret.open.entity.user.UserRole>
     * @Author: wujingsong
     * @Date: 2019/12/2  5:44 上午
     */
    List<UserRole> findByRoleIdAndS(String roleId,Integer s);
}
