package com.pret.user.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pret.user.system.domain.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
}