package com.pret.open.service.handler;

import com.alibaba.fastjson.JSONObject;
import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.common.utils.AESUtils;
import com.pret.open.service.user.UserService;
import com.pret.open.vo.req.P1000006Vo;
import com.pret.open.vo.req.P1000007Vo;
import com.pret.open.vo.res.PR1000006Vo;
import com.pret.open.vo.res.PR1000007Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: 输入u9code
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H1000007 extends BaseContext implements JopHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(H1000007.class);
    private static final String TAG = "H1000006";
    @Autowired
    private UserService userService;

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "解析手机号码");
        P1000007Vo res = (P1000007Vo) requestBody;
        return userService.inputU9Code(res);
    }
}
