package com.pret.open.vo.res;

import com.pret.api.info.TypeUserInfo;
import com.pret.api.vo.ResBody;
import com.pret.open.entity.user.User;
import lombok.Data;

/**
 * Description: 获取司机详情
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PR8000005Vo extends ResBody {
    private String openId;
    private String sessionKey;
    private String unionId;
    private String token;
    private TypeUserInfo typeUserInfo;
    private Integer authStatus;
    private Integer userType;
    private String nickName;
    private String avatarUrl;
}
