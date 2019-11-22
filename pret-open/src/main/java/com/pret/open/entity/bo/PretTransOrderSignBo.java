package com.pret.open.entity.bo;

import lombok.Data;

/**
 * <p>Description: 运输单</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransOrderSignBo {
    private String id;

    private Float signCount = 0.0f;

    private Float rejectCount = 0.0f;

    private String rejectReason;

    private String images;

}
