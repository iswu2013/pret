package com.pret.open.service.handler;

import com.alibaba.fastjson.JSONObject;
import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.common.utils.AESUtils;
import com.pret.open.service.PretTransOrderService;
import com.pret.open.vo.req.P1000006Vo;
import com.pret.open.vo.res.PR1000006Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: 解析手机号码
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H1000006 extends BaseContext implements JopHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(H1000006.class);
    private static final String TAG = "H1000006";

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "解析手机号码");
        P1000006Vo res = (P1000006Vo) requestBody;
        PR1000006Vo retVo = new PR1000006Vo();
        try {
            String decrypt = AESUtils.decrypt(res.getEncrypdata(), res.getSessionKey(), res.getIvdata(), "UTF-8");
            // 转成Json对象 获取openid
            JSONObject jsonObject = JSONObject.parseObject(decrypt);
            String phoneNumber = jsonObject.get("phoneNumber").toString();
            retVo.setPhoneNumber(phoneNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        retVo.setSerialNo(res.getSerialNo());
        return retVo;
    }
}
