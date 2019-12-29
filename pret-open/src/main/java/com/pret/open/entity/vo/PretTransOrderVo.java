package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransOrderVo extends PageFormVo implements Serializable {
    private String eq$venderId;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private String eq$pickupFactoryCd;
    private Date bw$takeDeliveryDate;
    private Date takeDeliveryDateEnd;
    private long takeDeliveryDateLong;
    private long takeDeliveryDateLongEnd;
    private Date bw$deliveryDate;
    private Date deliveryDateEnd;
    private String l$deliveryBillNumber;
    private int eq$status = -1;
    private String eq$salesId;
    private String eq$customerId;
    private String eq$deptId;
}
