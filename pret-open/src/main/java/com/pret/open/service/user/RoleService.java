package com.pret.open.service.user;


import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.BusinessException;
import com.pret.open.constant.OpenBEEnum;
import com.pret.open.entity.PretCustomer;
import com.pret.open.entity.user.Role;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.user.RoleVo;
import com.pret.open.entity.vo.user.UserVo;
import com.pret.open.repository.PretCustomerRepository;
import com.pret.open.repository.user.RoleRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.vo.req.P1000004Vo;
import com.pret.open.vo.res.PR1000004Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [t服务]
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class RoleService extends BaseServiceImpl<RoleRepository, Role, RoleVo> {

}
