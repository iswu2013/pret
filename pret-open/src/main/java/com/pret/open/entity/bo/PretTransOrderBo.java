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
    private String serviceRouteOrginId;

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

    public String getServiceRouteOrginId() {
        return serviceRouteOrginId;
    }

    public void setServiceRouteOrginId(String serviceRouteOrginId) {
        this.serviceRouteOrginId = serviceRouteOrginId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGw() {
        return gw;
    }

    public void setGw(Integer gw) {
        this.gw = gw;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public float getCbm() {
        return cbm;
    }

    public void setCbm(float cbm) {
        this.cbm = cbm;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}
