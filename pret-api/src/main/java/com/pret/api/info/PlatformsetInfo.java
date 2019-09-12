package com.pret.api.info;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: PlatformsetInfo
 * @projectName pert
 * @description: 平台基础数据设置
 * @date 2019/6/27 7:14
 */
public class PlatformsetInfo extends  BaseInfo{
    private String id;

    /**
     * 类型
     * 1用户提现手续费
     * 2企业对公账户信息
     */
    private Integer setType;

    /**
     * 提现手续费
     * 普通用户提现手续费
     * 0.1=10%
     */
    private BigDecimal chargeRate;

    /**
     * 下单起始时间
     */
    private String orderStartTime;

    /**
     * 下单结束时间
     */
    private String orderEndTime;

    /**
     * 最早配送时间类别
     */
    private Integer earliestDeliveryType;

    /**
     * 最早配送开始时间
     */
    private String earliestDeliveryStartTime;

    /**
     * 最早配送结束时间
     */
    private String earliestDeliveryEndTime;

    /**
     * 账号
     */
    private String account;

    /**
     * sort code
     */
    private String sortCode;

    /**
     * iban
     */
    private String iban;

    /**
     * swift
     */
    private String swift;

    /**
     * 企业地址
     */
    private String enterpriseAddress;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createLoginName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSetType() {
        return setType;
    }

    public void setSetType(Integer setType) {
        this.setType = setType;
    }

    public BigDecimal getChargeRate() {
        return chargeRate;
    }

    public void setChargeRate(BigDecimal chargeRate) {
        this.chargeRate = chargeRate;
    }

    public String getOrderStartTime() {
        return orderStartTime;
    }

    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    public String getOrderEndTime() {
        return orderEndTime;
    }

    public void setOrderEndTime(String orderEndTime) {
        this.orderEndTime = orderEndTime;
    }

    public Integer getEarliestDeliveryType() {
        return earliestDeliveryType;
    }

    public void setEarliestDeliveryType(Integer earliestDeliveryType) {
        this.earliestDeliveryType = earliestDeliveryType;
    }

    public String getEarliestDeliveryStartTime() {
        return earliestDeliveryStartTime;
    }

    public void setEarliestDeliveryStartTime(String earliestDeliveryStartTime) {
        this.earliestDeliveryStartTime = earliestDeliveryStartTime;
    }

    public String getEarliestDeliveryEndTime() {
        return earliestDeliveryEndTime;
    }

    public void setEarliestDeliveryEndTime(String earliestDeliveryEndTime) {
        this.earliestDeliveryEndTime = earliestDeliveryEndTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }
}
