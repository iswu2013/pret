package com.pret.user.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.pret.user.system.domain.UserRole;

import java.util.List;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String[] roleIds);

	void deleteUserRolesByUserId(String[] userIds);

	List<String> findUserIdsByRoleId(String[] roleIds);
}
