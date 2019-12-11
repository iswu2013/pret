package com.pret.open.service.handler;

import com.alibaba.fastjson.JSONObject;
import com.pret.api.feign.IUserService;
import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.info.TypeUserInfo;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.utils.AESUtils;
import com.pret.common.utils.HttpUtil;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.entity.user.User;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.vo.req.P1000006Vo;
import com.pret.open.vo.req.P8000005Vo;
import com.pret.open.vo.res.PR1000006Vo;
import com.pret.open.vo.res.PR8000005Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.UUID;

/**
 * Description: 获取openid
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H8000005 extends BaseContext implements JopHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(H8000005.class);
    private static final String TAG = "H1000000";
    @Autowired
    private PretMemberAuthRepository pretMemberAuthRepository;
    // 不需要登录的接口
    @Autowired
    protected BaseContext baseContext;

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "获取openid");
        P8000005Vo res = (P8000005Vo) requestBody;
        PR8000005Vo retVo = new PR8000005Vo();
        // 微信小程序ID
        String appid = "wxa470663bb75476a1";
        // 微信小程序秘钥
        String secret = "06efcbabef8295944c78ce00a7bfa101";

        // 根据小程序穿过来的code想这个url发送请求
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secret + "&js_code=" + res.getCode() + "&grant_type=authorization_code";
        // 发送请求，返回Json字符串
        String str = null;
        try {
            str = HttpUtil.sendGet(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转成Json对象 获取openid
        JSONObject jsonObject = JSONObject.parseObject(str);

        // 我们需要的openid，在一个小程序中，openid是唯一的
        String openid = jsonObject.get("openid").toString();
        retVo.setOpenId(openid);
        retVo.setSessionKey(jsonObject.get("session_key").toString());

        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(openid, ConstantEnum.S.N.getLabel());
        if (pretMemberAuth != null) {
            retVo.setAuthStatus(pretMemberAuth.getStatus());
            retVo.setUserType(pretMemberAuth.getUserType());
        } else {
            retVo.setAuthStatus(ConstantEnum.EAuthStatus.不存在.getLabel());
        }
        TypeUserInfo userInfo = new TypeUserInfo();
        userInfo.setOpenid(openid);
        userInfo = baseContext.getiUserService().findByOpenid(userInfo);
        retVo.setData(userInfo);

        return retVo;
    }
}
