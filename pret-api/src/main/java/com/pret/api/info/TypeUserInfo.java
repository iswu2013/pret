package com.pret.api.info;

/**
 * @author wujingsong
 * @title: TypeUserInfo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/208:47 下午
 */
public class TypeUserInfo {
    private Integer type;

    private String openid;

    private CustomerInfo customerInfo;

    private DriverInfo driverInfo;

    private UserInfo userInfo;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public DriverInfo getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(DriverInfo driverInfo) {
        this.driverInfo = driverInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
