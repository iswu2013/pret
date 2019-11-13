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
public class PretTransOrderBo {
    /**
     * 运输方式
     */
    @ExcelField(value = "运输方式")
    private String transMode;

    /**
     * 提货日期
     */
    private Date takeDeliveryDate;

    /**
     * 送达日期
     */
    private Date deliveryDate;

    /**
     * 送货单号
     */
    private String deliveryBillNumber;

    /**
     * 起运地
     */
    private String serviceRouteOriginId;

    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 客户地址
     */
    private String customerAddress;

    /**
     * 客户联系人
     */
    private String customerLinkName;

    /**
     * 客户联系人电话
     */
    private String customerLinkPhone;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品重量
     */
    private Integer gw;

    /**
     * 单位(1吨，2公斤)
     */
    private int unit;

    /**
     * 立方体积
     */
    private float cbm;

    /**
     * 货物件数
     */
    private int goodsNum;
}
