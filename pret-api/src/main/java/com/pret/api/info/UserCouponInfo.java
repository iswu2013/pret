package com.pret.api.info;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: UserCouponInfo
 * @projectName pert
 * @description: TODO
 * @date 2019/6/2710:11
 */
public class UserCouponInfo extends BaseInfo {
    private String id;

    /**
     * 优惠券规则标识
     */
    private String regularId;

    /**
     *  票券金额
     */
    private Integer cpAmount;

    /**
     * 送券时间
     */
    private String cpSendTime;

    /**
     *  送券时间
     */
    private String cpEndTime;

    /**
     * 是否有效
     * 0:正常
     * 1:已使用
     * 2:失效
     * 3：删除
     */
    private Integer cpStatus;

    /**
     * 绑定的订单号
     */
    private String orderNo;

    /**
     * 票券类型
     * 0通用券
     * 1折扣券
     * 2满减
     * 3特定券
     * 4兑换码
     */
    private Integer cpType;


    /**
     * 折扣比例,折扣券时使用，示例0.7=7折
     */
    private BigDecimal discountRatio;

    /**
     * 满总金额，满减券时使用
     */
    private BigDecimal totalAmount;

    /**
     * 减金额,满减券时使用
     */
    private BigDecimal discountAmount;

    /**
     * 备注,满40可用
     */
    private String cpNote;

    /**
     * 票券所有者
     */
    private String uid;

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

    public String getRegularId() {
        return regularId;
    }

    public void setRegularId(String regularId) {
        this.regularId = regularId;
    }

    public Integer getCpAmount() {
        return cpAmount;
    }

    public void setCpAmount(Integer cpAmount) {
        this.cpAmount = cpAmount;
    }

    public String getCpSendTime() {
        return cpSendTime;
    }

    public void setCpSendTime(String cpSendTime) {
        this.cpSendTime = cpSendTime;
    }

    public String getCpEndTime() {
        return cpEndTime;
    }

    public void setCpEndTime(String cpEndTime) {
        this.cpEndTime = cpEndTime;
    }

    public Integer getCpStatus() {
        return cpStatus;
    }

    public void setCpStatus(Integer cpStatus) {
        this.cpStatus = cpStatus;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCpType() {
        return cpType;
    }

    public void setCpType(Integer cpType) {
        this.cpType = cpType;
    }

    public BigDecimal getDiscountRatio() {
        return discountRatio;
    }

    public void setDiscountRatio(BigDecimal discountRatio) {
        this.discountRatio = discountRatio;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getCpNote() {
        return cpNote;
    }

    public void setCpNote(String cpNote) {
        this.cpNote = cpNote;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }
}
