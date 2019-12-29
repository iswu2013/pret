package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
public class PretPickUpPlanVo extends PageFormVo implements Serializable {
    private String eq$venderId;
    private String eq$tallyClerkId;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private int eq$status = -1;
    private String eq$driverId;
    private Date bw$pickUpTime;
    private Date pickUpTimeEnd;
    private String eq$pickupFactoryCd;
    private int eq$stockUpStatus = -1;
    private String eq$deptId;
    private List<String> in$deptId;
    private String userId;
    private String l$tallyClerkIds;
    private String eq$ownFactoryCd;
    private String l$no;
    private String eq$serviceRouteOriginId;
    private String noSorter;
    private String noSorterType;
    private String createTimeLongSorter;
    private String createTimeLongSorterType;
    private String pickUpTimeSorter;
    private String pickUpTimeSorterType;
    private String startTimeSorter;
    private String startTimeSorterType;
    private String endTimeSorter;
    private String endTimeSorterType;
    private String venderIdSorter;
    private String venderIdSorterType;
    private String serviceRouteOriginIdSorter;
    private String serviceRouteOriginIdSorterType;
}
