package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;

import java.io.Serializable;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class PretTransExceptionItemVo extends PageFormVo implements Serializable{
    private long bw$createTimeLong;
    private long createTimeLongEnd;

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
