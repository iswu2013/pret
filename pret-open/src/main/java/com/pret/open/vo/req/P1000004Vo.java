package com.pret.open.vo.req;

import com.pret.api.vo.PageFormVo;

/**
 * Description: 绑定用户
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class P1000004Vo extends PageFormVo {
    private String openid;

    private String phone;

    /**
     * 用户类型
     */
    private Integer type;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
