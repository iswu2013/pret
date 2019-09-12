package com.pret.api.info;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: UsedOrderInfo
 * @projectName pert
 * @description: 二手商品
 * @date 2019/7/13 8:45
 */
public class UsedOrderInfo extends BaseInfo {
    private String id;

    /**
     * 订单号
     * 规则UO开头
     */
    private String orderNo;

    /**
     * 子订单号
     */
    private String subOrderNo;

    /**
     * 订单类型
     * 0正常
     * 1预订单
     */
    private Integer  orderType;

    /**
     * 类别
     * 0默认
     * 1其他(预留)
     */
    private Integer orderCategory;

    /**
     * 总数量
     */
    private Integer quantity;

    /**
     * 支付总金额
     */
    private BigDecimal payAmount;

    /**
     * 总包装费
     */
    private BigDecimal packingFee;

    /**
     * 配送费,该笔配送费
     */
    private BigDecimal sendFee;

    /**
     * 用户承担配送费,预留字段
     */
    private BigDecimal customSendFee;

    /**
     * 服务费,一单一扣时使用，先预留
     */
    private BigDecimal serviceFee;

    /**
     * 购买人
     */
    private String uid;

    /**
     * 配送状态
     * 1 接单，默认
     * 2 已送达
     */
    private Integer sendStatus;

    /**
     * 送达时间
     */
    private String sendArriveTime;

    /**
     * 配送人员id
     */
    private String sendUid;

    /**
     * 配送员手机号
     */
    private String smobile;

    /**
     * 总耗时
     */
    private String totalTime;

    /**
     * 订单状态
     * 0 未支付
     * 1 已支付
     * 2 退款
     * 4已取消
     */
    private int status;

    /**
     * 商家确认状态
     * 0已确认，默认
     * 1未确认
     */
    private Integer busiStatus;

    /**
     * 商家确认时间
     */
    private String busiConfirmTime;

    /**
     * 收货地址
     */
    private String receptionAddress;

    /**
     * 备注
     */
    private String remark;

    /**
     * 商铺id
     */
    private String busiId;

    /**
     * 学校id,预留
     */
    private String schoolId;

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

    public String getSubOrderNo() {
        return subOrderNo;
    }

    public void setSubOrderNo(String subOrderNo) {
        this.subOrderNo = subOrderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderCategory() {
        return orderCategory;
    }

    public void setOrderCategory(Integer orderCategory) {
        this.orderCategory = orderCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(BigDecimal packingFee) {
        this.packingFee = packingFee;
    }

    public BigDecimal getSendFee() {
        return sendFee;
    }

    public void setSendFee(BigDecimal sendFee) {
        this.sendFee = sendFee;
    }

    public BigDecimal getCustomSendFee() {
        return customSendFee;
    }

    public void setCustomSendFee(BigDecimal customSendFee) {
        this.customSendFee = customSendFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public String getSendArriveTime() {
        return sendArriveTime;
    }

    public void setSendArriveTime(String sendArriveTime) {
        this.sendArriveTime = sendArriveTime;
    }

    public String getSendUid() {
        return sendUid;
    }

    public void setSendUid(String sendUid) {
        this.sendUid = sendUid;
    }

    public String getSmobile() {
        return smobile;
    }

    public void setSmobile(String smobile) {
        this.smobile = smobile;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getBusiStatus() {
        return busiStatus;
    }

    public void setBusiStatus(Integer busiStatus) {
        this.busiStatus = busiStatus;
    }

    public String getBusiConfirmTime() {
        return busiConfirmTime;
    }

    public void setBusiConfirmTime(String busiConfirmTime) {
        this.busiConfirmTime = busiConfirmTime;
    }

    public String getReceptionAddress() {
        return receptionAddress;
    }

    public void setReceptionAddress(String receptionAddress) {
        this.receptionAddress = receptionAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }
}
