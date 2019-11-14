package com.pret.open.entity.bo;

import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.util.Date;

/**
 * <p>Description: 运输单</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretMTransOrderItemBo {
    /**
     * 料号
     */
    private String partNo;
    /**
     * 批号
     */
    private String batchNo;
    /**
     * 品名
     */
    private String product;
    /**
     * 商品重量
     */
    private Float weight;
    /**
     * 商品单位
     */
    private Integer unit;

    /**
     * 立方米
     */
    private float cbm;

    /**
     * 货物类型1重货2泡货
     */
    private Integer goodsType;

    private Integer goodsNum;
}
