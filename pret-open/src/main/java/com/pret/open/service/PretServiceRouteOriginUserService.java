package com.pret.open.service;

import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.PretDriver;
import com.pret.open.entity.PretServiceRouteOriginUser;
import com.pret.open.entity.vo.PretDriverVo;
import com.pret.open.entity.vo.PretServiceRouteOriginUserVo;
import com.pret.open.repository.PretDriverRepository;
import com.pret.open.repository.PretServiceRouteOriginUserRepository;
import com.pret.open.vo.req.P8000004Vo;
import com.pret.open.vo.res.PR8000004Vo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretServiceRouteOriginUserService extends BaseServiceImpl<PretServiceRouteOriginUserRepository, PretServiceRouteOriginUser, PretServiceRouteOriginUserVo> {
}
