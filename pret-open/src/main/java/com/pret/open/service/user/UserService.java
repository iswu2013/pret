package com.pret.open.service.user;


import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.api.vo.ResBody;
import com.pret.open.entity.user.User;
import com.pret.open.entity.vo.user.UserVo;
import com.pret.open.repository.user.UserRepository;
import com.pret.open.vo.req.P1000004Vo;
import com.pret.open.vo.res.PR1000004Vo;
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
public class UserService extends BaseServiceImpl<UserRepository, User, UserVo> {

    /* *
     * 功能描述: 绑定用户
     * 〈〉
     * @Param: [res]
     * @Return: com.pret.api.vo.ResBody
     * @Author: wujingsong
     * @Date: 2019/10/19  6:30 上午
     */
    public ResBody bindUser(P1000004Vo res) {
        PR1000004Vo retVo = new PR1000004Vo();

        return retVo;
    }
}
