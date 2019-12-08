package com.pret.open.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * <p>Description: 签收</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransPlanSignBo {
    /**
     * 运输单
     */
    private String id;

    private String ids;

    private String username;

    /**
     * 签收时间
     */
    private Date signDatetime;

    /**
     * 是否有异常
     */
    private boolean hasException;

    /**
     * 签收情况
     */
    private String pretTransOrderSignBoStr;

    private String images;
}
