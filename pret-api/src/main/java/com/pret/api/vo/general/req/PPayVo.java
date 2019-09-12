package com.pret.api.vo.general.req;


import com.pret.api.vo.ReqBody;

import java.math.BigDecimal;

/**
 * 订单支付接口
 *
 * @author wujinsong
 */
public class PPayVo extends ReqBody {

    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;

    /**
     * 押金金额
     */
    private BigDecimal pledgeAmount;

    /**
     * 押金状态
     * 0无
     * 1正常
     * 2已退
     */
    private Integer pledgeStatus;

    /**
     * 快递费
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
     * 支付类别
     */
    private int payType;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 信用卡id
     */
    private String creditCardId;

    /**
     * 创建的ip地址
     */
    private String createIp;

    private String toUserId;

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

    public Integer getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(Integer pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
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

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCreateIp() {
        return createIp;
    }

    public void setCreateIp(String createIp) {
        this.createIp = createIp;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
}
