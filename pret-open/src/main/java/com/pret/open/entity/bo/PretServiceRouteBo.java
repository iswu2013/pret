package com.pret.open.entity.bo;

import lombok.Data;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretServiceRouteBo {
    private String id;
    /**
     * 线路名称
     */
    private String name;

    private String serviceRouteItemStr;
}
