package com.pret.open.entity.bo;

import com.wuwenze.poi.annotation.ExcelField;

import java.util.Date;

/**
 * <p>Description: 运输单</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
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
     * 送达客户id
     */
    @ExcelField(value = "送达客户id")
    private String customerId;

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

    private String pretMTransOrderItemStr;

    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    public Date getTakeDeliveryDate() {
        return takeDeliveryDate;
    }

    public void setTakeDeliveryDate(Date takeDeliveryDate) {
        this.takeDeliveryDate = takeDeliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryBillNumber() {
        return deliveryBillNumber;
    }

    public void setDeliveryBillNumber(String deliveryBillNumber) {
        this.deliveryBillNumber = deliveryBillNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerLinkName() {
        return customerLinkName;
    }

    public void setCustomerLinkName(String customerLinkName) {
        this.customerLinkName = customerLinkName;
    }

    public String getCustomerLinkPhone() {
        return customerLinkPhone;
    }

    public void setCustomerLinkPhone(String customerLinkPhone) {
        this.customerLinkPhone = customerLinkPhone;
    }

    public String getPickupFactoryCd() {
        return pickupFactoryCd;
    }

    public void setPickupFactoryCd(String pickupFactoryCd) {
        this.pickupFactoryCd = pickupFactoryCd;
    }

    public String getPretMTransOrderItemStr() {
        return pretMTransOrderItemStr;
    }

    public void setPretMTransOrderItemStr(String pretMTransOrderItemStr) {
        this.pretMTransOrderItemStr = pretMTransOrderItemStr;
    }
}
