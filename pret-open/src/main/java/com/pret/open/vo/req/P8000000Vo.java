package com.pret.open.vo.req;

import com.pret.api.vo.PageFormVo;

import java.util.Date;

/**
 * Description: 获取司机备货列表
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class P8000000Vo extends PageFormVo {
    private String openid;

    private int status;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
