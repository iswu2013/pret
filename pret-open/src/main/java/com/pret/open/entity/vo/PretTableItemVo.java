package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;

import java.io.Serializable;

/**
 * <p>Description: [plutomodel]</p>
 * Created on 2019年10月03日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class PretTableItemVo extends PageFormVo implements Serializable{
    private String l$name;

    private String eq$module;

    private long bw$createTimeLong;
    private long createTimeLongEnd;

    public String getL$name() {
        return l$name;
    }

    public void setL$name(String l$name) {
        this.l$name = l$name;
    }

    public String getEq$module() {
        return eq$module;
    }

    public void setEq$module(String eq$module) {
        this.eq$module = eq$module;
    }

    public long getBw$createTimeLong() {
        return bw$createTimeLong;
    }

    public void setBw$createTimeLong(long bw$createTimeLong) {
        this.bw$createTimeLong = bw$createTimeLong;
    }

    public long getCreateTimeLongEnd() {
        return createTimeLongEnd;
    }

    public void setCreateTimeLongEnd(long createTimeLongEnd) {
        this.createTimeLongEnd = createTimeLongEnd;
    }
}