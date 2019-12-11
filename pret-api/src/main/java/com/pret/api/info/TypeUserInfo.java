package com.pret.api.info;

import lombok.Data;

/**
 * @author wujingsong
 * @title: TypeUserInfo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/208:47 下午
 */
@Data
public class TypeUserInfo {
    private Integer type;

    private String openid;

    private CustomerInfo customerInfo;

    private DriverInfo driverInfo;

    private UserInfo userInfo;

    private Integer authStatus;

    private String nickName;

    private String avatarUrl;
}
