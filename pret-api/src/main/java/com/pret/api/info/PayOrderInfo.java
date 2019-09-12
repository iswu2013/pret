package com.pret.api.info;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: PayOrderInfo
 * @projectName pert
 * @description: 支付订单
 * @date 2019/7/13 20:15
 */
public class PayOrderInfo extends BaseInfo {
    private String id;

    /**
     * 业务订单号
     */
    private String orderNo;

    /**
     * 订单类型
     * 0美食
     * 1商超
     * 2二手
     * 3租房
     * 4充值
     */
    private Integer orderType;

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 押金金额
     */
    private BigDecimal pledgeAmount;

    /**
     * 快递费（默认为0）
     */
    private BigDecimal logisticsAmount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 实际支付金额
     */
    private BigDecimal payAmount;

    /**
     * 支付状态
     * 0未支付
     * 1已支付
     * 2退款
     * 3纠纷中
     * 4已取消（超时）15分钟未支付自动取消
     */
    private Integer payStatus;

    /**
     * 支付方式
     * 0未知
     * 1微信
     * 2支付宝
     * 3银联
     * 4余额支付
     * 5 worldpay
     */
    private Integer payType;

    /**
     * 押金状态
     * 0无
     * 1正常
     * 2已退
     */
    private Integer pledgeStatus;

    /**
     * 交易付款时间(支付)
     */
    private String gmtPayment;

    /**
     * 交易创建时间
     */
    private String gmtCreate;

    /**
     * 交易订单状态
     */
    private String tradeStatus;

    /**
     * 支付订单号
     * 微信支付订单号
     * 支付宝支付订单号
     * 三方支付单号
     */
    private String transactionId;

    /**
     * 付款人
     */
    private String uid;

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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(BigDecimal pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public BigDecimal getLogisticsAmount() {
        return logisticsAmount;
    }

    public void setLogisticsAmount(BigDecimal logisticsAmount) {
        this.logisticsAmount = logisticsAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(Integer pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
    }

    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
