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
public class PretTransOrderVo extends PageFormVo implements Serializable{
    private String eq$venderId;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private String eq$pickupFactoryCd;
    private Date bw$takeDeliveryDate;
    private Date takeDeliveryDateEnd;
    private Date bw$deliveryDate;
    private Date deliveryDateEnd;
    private String l$deliveryBillNumber;

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

    public String getEq$pickupFactoryCd() {
        return eq$pickupFactoryCd;
    }

    public void setEq$pickupFactoryCd(String eq$pickupFactoryCd) {
        this.eq$pickupFactoryCd = eq$pickupFactoryCd;
    }

    public Date getBw$takeDeliveryDate() {
        return bw$takeDeliveryDate;
    }

    public void setBw$takeDeliveryDate(Date bw$takeDeliveryDate) {
        this.bw$takeDeliveryDate = bw$takeDeliveryDate;
    }

    public Date getTakeDeliveryDateEnd() {
        return takeDeliveryDateEnd;
    }

    public void setTakeDeliveryDateEnd(Date takeDeliveryDateEnd) {
        this.takeDeliveryDateEnd = takeDeliveryDateEnd;
    }

    public Date getBw$deliveryDate() {
        return bw$deliveryDate;
    }

    public void setBw$deliveryDate(Date bw$deliveryDate) {
        this.bw$deliveryDate = bw$deliveryDate;
    }

    public Date getDeliveryDateEnd() {
        return deliveryDateEnd;
    }

    public void setDeliveryDateEnd(Date deliveryDateEnd) {
        this.deliveryDateEnd = deliveryDateEnd;
    }

    public String getL$deliveryBillNumber() {
        return l$deliveryBillNumber;
    }

    public void setL$deliveryBillNumber(String l$deliveryBillNumber) {
        this.l$deliveryBillNumber = l$deliveryBillNumber;
    }
}
