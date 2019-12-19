package com.pret.open.service.handler;

import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.open.entity.PretMemberAuth;
import com.pret.open.repository.PretMemberAuthRepository;
import com.pret.open.service.user.DeptService;
import com.pret.open.vo.req.P8000010Vo;
import com.pret.open.vo.req.P8000011Vo;
import com.pret.open.vo.res.PR8000011Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: 获取用户信息
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class H8000011 extends BaseContext implements JopHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(H8000011.class);
    private static final String TAG = "H8000009";
    @Autowired
    private PretMemberAuthRepository pretMemberAuthRepository;

    @Override
    public ResBody handle(ReqBody requestBody) {
        LOGGER.info(TAG, "获取部门");
        P8000011Vo res = (P8000011Vo) requestBody;
        PR8000011Vo retVo = new PR8000011Vo();
        retVo.setData(res.getUserInfo());

        PretMemberAuth pretMemberAuth = pretMemberAuthRepository.findByOpenidAndS(res.getOpenid(), ConstantEnum.S.N.getLabel());
        if (pretMemberAuth != null) {
            retVo.setAuthStatus(pretMemberAuth.getStatus());
            retVo.setUserType(pretMemberAuth.getUserType());
        } else {
            retVo.setAuthStatus(ConstantEnum.EAuthStatus.不存在.getLabel());
        }

        retVo.setSerialNo(res.getSerialNo());
        return retVo;
    }
}
