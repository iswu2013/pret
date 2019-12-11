package com.pret.open.vo.req;

import com.pret.api.vo.ReqBody;
import com.pret.common.constant.ConstantEnum;
import lombok.Data;

/**
 * Description: 输入u9code
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class P1000007Vo extends ReqBody {
    private Integer userType;

    private String name;

    private String mobile;

    private String openid;

    private String no;

    private String serviceRouteOriginId;

    private String authUsername;

    private Long authDate;

    private String nickName;

    private String avatarUrl;

    private String deptId;
}
