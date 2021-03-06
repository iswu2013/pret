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
public class PretTransFeeVo extends PageFormVo implements Serializable {
    private String eq$venderId;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private long bw$transDatetimeLong;
    private long transDatetimeLongEnd;
    private int eq$status = -1;
    private String eq$transStatementId;
    private List<Integer> in$status;
    private String eq$pretCurrencyId;
    private boolean searchStatus = false;
    private String eq$deptId;
    private List<String> in$deptId;
    private String userId;
    private int eq$checkStatus = -1;
    private String l$transNo;
}
