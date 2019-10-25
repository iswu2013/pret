package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;

import java.io.Serializable;

/**
 * @author wujingsong
 * @title: PretTransOrderStatisticsVo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/247:35 下午
 */
public class PretTransOrderStatisticsVo extends PageFormVo implements Serializable {
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
