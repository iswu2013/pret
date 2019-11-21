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
public class PretServiceRouteItemBo {
    /**
     * 起运地id
     */
    private String serviceRouteOriginId;
    /**
     * 地址id
     */
    private String value;
    /**
     * 时效(天)
     */
    private Float prescription;

    /**
     * 里程
     */
    private Float mileage;

    /**
     * 自动分配下限
     */
    private Float lowerLimit;

}
