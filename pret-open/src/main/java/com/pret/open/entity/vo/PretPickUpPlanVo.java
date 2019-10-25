package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 * @author  <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0 
 * Copyright (c) 2019年 极客城堡
 */
public class PretPickUpPlanVo extends PageFormVo implements Serializable{
    private String eq$venderId;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private int eq$status = -1;
    private String eq$driverId;
    private Date bw$pickUpTime;
    private Date pickUpTimeEnd;

    public String getEq$venderId() {
        return eq$venderId;
    }

    public void setEq$venderId(String eq$venderId) {
        this.eq$venderId = eq$venderId;
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

    public int getEq$status() {
        return eq$status;
    }

    public void setEq$status(int eq$status) {
        this.eq$status = eq$status;
    }

    public String getEq$driverId() {
        return eq$driverId;
    }

    public void setEq$driverId(String eq$driverId) {
        this.eq$driverId = eq$driverId;
    }

    public Date getBw$pickUpTime() {
        return bw$pickUpTime;
    }

    public void setBw$pickUpTime(Date bw$pickUpTime) {
        this.bw$pickUpTime = bw$pickUpTime;
    }

    public Date getPickUpTimeEnd() {
        return pickUpTimeEnd;
    }

    public void setPickUpTimeEnd(Date pickUpTimeEnd) {
        this.pickUpTimeEnd = pickUpTimeEnd;
    }
}
