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
public class PretTransExceptionVo extends PageFormVo implements Serializable {
    private String eq$venderId;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private int eq$status;
    private List<String> in$deptId;
    private String userId;
}
