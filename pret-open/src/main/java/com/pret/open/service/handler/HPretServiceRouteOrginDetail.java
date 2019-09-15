package com.pret.open.service.handler;

import java.util.List;

import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.api.filter.BaseContext;
import com.pret.open.vo.req.PPretServiceRouteOrginDetailVo;
import com.pret.api.handler.JopHandler;
import com.pret.open.service.PretServiceRouteOrginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class HPretServiceRouteOrginDetail extends BaseContext implements JopHandler{
    private static final Logger LOGGER = LoggerFactory.getLogger(HPretServiceRouteOrginDetail.class);
    private static final String TAG = "HPretServiceRouteOrginSave";
    @Autowired
    private PretServiceRouteOrginService pretServiceRouteOrginService;

    @Override
    public ResBody handle(ReqBody requestBody) {
        PPretServiceRouteOrginDetailVo res = (PPretServiceRouteOrginDetailVo) requestBody;
        return pretServiceRouteOrginService.detail(res);
    }
}
