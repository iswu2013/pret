package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;

import java.io.Serializable;
/** 
 * <p>Description: [pretmodel]</p>
 * Created on 2019年10月25日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class PretFeeTypeVo extends PageFormVo implements Serializable{
    private String l$no;
    private String l$name;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private int eq$goodsType;

    public String getL$no() {
        return l$no;
    }

    public void setL$no(String l$no) {
        this.l$no = l$no;
    }

    public String getL$name() {
        return l$name;
    }

    public void setL$name(String l$name) {
        this.l$name = l$name;
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

    public int getEq$goodsType() {
        return eq$goodsType;
    }

    public void setEq$goodsType(int eq$goodsType) {
        this.eq$goodsType = eq$goodsType;
    }
}
