package com.pret.open.service.handler;

import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.open.service.PretPickUpPlanService;
import com.pret.open.service.user.UserService;
import com.pret.open.vo.req.P1000003Vo;
import com.pret.open.vo.req.P1000004Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: 绑定用户
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H1000004 extends BaseContext implements JopHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(H1000004.class);
    private static final String TAG = "H1000004";
    @Autowired
    private UserService service;

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "绑定用户");
        P1000004Vo res = (P1000004Vo) requestBody;
        return service.bindUser(res);
    }
}
