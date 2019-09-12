package com.pret.api.vo.general.res;

/**
 * 订单支付接口 worldpay 返回
 *
 * @author lwl
 */
public class PRPayWpItemVo {

    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 返回状态码
     */
    private String paymentStatus;

    /**
     * 返回信息
     */
    private String paymentStatusReason;

    /**
     * 客户订单号
     */
    private String customerOrderCode;

    /**
     * 跳转URL
     */
    private String redirectURL;

    /**
     * 结果代码
     */
    private String resultCodes;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentStatusReason() {
        return paymentStatusReason;
    }

    public void setPaymentStatusReason(String paymentStatusReason) {
        this.paymentStatusReason = paymentStatusReason;
    }

    public String getCustomerOrderCode() {
        return customerOrderCode;
    }

    public void setCustomerOrderCode(String customerOrderCode) {
        this.customerOrderCode = customerOrderCode;
    }

    public String getRedirectURL() {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }

    public String getResultCodes() {
        return resultCodes;
    }

    public void setResultCodes(String resultCodes) {
        this.resultCodes = resultCodes;
    }
}

