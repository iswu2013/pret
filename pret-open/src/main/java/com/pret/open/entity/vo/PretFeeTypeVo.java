package com.pret.open.entity.vo;

import com.pret.api.vo.PageFormVo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年10月25日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretFeeTypeVo extends PageFormVo implements Serializable {
    private String l$no;
    private String l$name;
    private long bw$createTimeLong;
    private long createTimeLongEnd;
    private int eq$goodsType = -1;
}
