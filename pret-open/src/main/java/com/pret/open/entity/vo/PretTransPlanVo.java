package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransPlanVo extends PageFormVo implements Serializable {
    private String eq$venderId;
    private String l$no;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private String eq$customerId;
    private int eq$status = -1;
    private String eq$pickupFactoryCd;
    private int eq$type = -1;
    private String eq$deptId;
    private String eq$salesId;
    private List<String> in$deptId;
    private String userId;
    private String eq$custCd;
    private String bw$transDatetime;
    private String transDatetimeEnd;
    private long transDatetimeLong;
    private long transDatetimeLongEnd;
    private String eq$serviceRouteOriginId;
    private List<Integer> in$status;
}
