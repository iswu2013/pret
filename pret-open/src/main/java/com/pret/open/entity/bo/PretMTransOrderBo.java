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
public class PretMTransOrderBo {
    /**
     * 运输方式
     */
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
     * 客户编码
     */
    private String custCd;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户地址
     */
    private String customerAddress;

    /**
     * 客户地址
     */
    private String addressId;

    /**
     * 客户联系人
     */
    private String customerLinkName;
    /**
     * 客户联系人电话
     */
    private String customerLinkPhone;

    /**
     * 提货工厂code
     */
    private String pickupFactoryCd;

    /**
     * 起运地id
     */
    private String serviceRouteOriginId;

    /**
     * 销售备注
     */
    private String remark;

    /**
     * 储位
     */
    private String storageNumber;

    private String transModeNm;

    private String pretMTransOrderItemStr;

    /**
     * 所属工厂code
     */
    private String ownFactoryCd;

}
