package com.pret.open.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description: 起运确认</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransPlanStartShipmentConfirmBo {
    /**
     * id
     */
    private String id;

    /**
     * 起运日期
     */
    private Date transDatetime;


    private Date preDeliveryDate;
}
