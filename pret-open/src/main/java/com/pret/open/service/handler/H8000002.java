package com.pret.open.service.handler;

import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.open.service.PretPickUpPlanService;
import com.pret.open.service.PretTransPlanService;
import com.pret.open.vo.req.P8000001Vo;
import com.pret.open.vo.req.P8000002Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: 获取用户运输计划
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H8000002 extends BaseContext implements JopHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(H8000002.class);
    private static final String TAG = "H1000000";
    @Autowired
    private PretTransPlanService service;

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "获取待备货详情");
        P8000002Vo res = (P8000002Vo) requestBody;
        return service.getTransPanList(res);
    }
}
