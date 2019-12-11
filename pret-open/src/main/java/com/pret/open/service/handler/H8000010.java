package com.pret.open.service.handler;

import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.open.entity.PretServiceRouteOrigin;
import com.pret.open.service.PretServiceRouteOriginService;
import com.pret.open.service.PretTransPlanService;
import com.pret.open.service.user.DeptService;
import com.pret.open.vo.req.P8000009Vo;
import com.pret.open.vo.req.P8000010Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: 获取部门
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H8000010 extends BaseContext implements JopHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(H8000010.class);
    private static final String TAG = "H8000009";
    @Autowired
    private DeptService service;

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "获取部门");
        P8000010Vo res = (P8000010Vo) requestBody;
        return service.getDeptList(res);
    }
}
