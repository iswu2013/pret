package com.pret.api.info;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: FoodOrderItems
 * @projectName pert
 * @description: 美食订单明细表
 * @date 2019/6/11 22:15
 */
public class FoodOrderItemsInfo extends BaseInfo {
    /**
     * id
     */
    private String id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 商品id
     */
    private String objId;

    /**
     * 价格，当前成交价
     */
    private BigDecimal objPrice;

    /**
     * 原价
     */
    private BigDecimal costPrice;

    /**
     * 包装费
     */
    private BigDecimal packingFee;

    /**
     * 名称，中文
     */
    private String objName;

    /**
     * 名称，英文
     */
    private String objEname;

    /**
     * 数量
     */
    private Long payNum;

    /**
     * 中晚餐
     * 0中餐
     * 1晚餐
     */
    private Integer rtype;

    private String createTimeStr;

    private Long createTimeLong;// 创建时间

    private String iobjName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public BigDecimal getObjPrice() {
        return objPrice;
    }

    public void setObjPrice(BigDecimal objPrice) {
        this.objPrice = objPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(BigDecimal packingFee) {
        this.packingFee = packingFee;
    }

    @JsonIgnore()
    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    @JsonIgnore()
    public String getObjEname() {
        return objEname;
    }

    public void setObjEname(String objEname) {
        this.objEname = objEname;
    }

    public Long getPayNum() {
        return payNum;
    }

    public void setPayNum(Long payNum) {
        this.payNum = payNum;
    }

    public Integer getRtype() {
        return rtype;
    }

    public void setRtype(Integer rtype) {
        this.rtype = rtype;
    }

    public Long getCreateTimeLong() {
        return createTimeLong;
    }

    public void setCreateTimeLong(Long createTimeLong) {
        this.createTimeLong = createTimeLong;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getIobjName() {
        return iobjName;
    }

    public void setIobjName(String iobjName) {
        this.iobjName = iobjName;
    }
}
