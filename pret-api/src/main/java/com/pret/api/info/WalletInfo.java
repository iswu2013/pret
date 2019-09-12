package com.pret.api.info;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: Wallet
 * @projectName pert
 * @description: 用户钱包
 * @date 2019/6/1 08:19
 */
public class WalletInfo extends BaseInfo {
    private String id;

    /**
     * 用户标识
     */
    private String uid;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 交易金额
     */
    private BigDecimal transBalance;

    /**
     * 分销佣金
     */
    private BigDecimal distBalance;

    /**
     * 预收款
     */
    private BigDecimal waitBalance;

    /**
     * 支付宝账号
     */
    private String alipyNum;

    /**
     * 支付宝姓名
     */
    private String realName;

    /**
     * 信用卡号
     */
    private String creditCard;

    /**
     * 过期时间
     */
    private String exparationDate;

    /**
     * cvv号
     */
    private String cvv;

    /**
     * 添加金额
     */
   private BigDecimal addAmount;

    /**
     * 转账发出方
     */
   private String fromUid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getTransBalance() {
        return transBalance;
    }

    public void setTransBalance(BigDecimal transBalance) {
        this.transBalance = transBalance;
    }

    public BigDecimal getDistBalance() {
        return distBalance;
    }

    public void setDistBalance(BigDecimal distBalance) {
        this.distBalance = distBalance;
    }

    public BigDecimal getWaitBalance() {
        return waitBalance;
    }

    public void setWaitBalance(BigDecimal waitBalance) {
        this.waitBalance = waitBalance;
    }

    public String getAlipyNum() {
        return alipyNum;
    }

    public void setAlipyNum(String alipyNum) {
        this.alipyNum = alipyNum;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getExparationDate() {
        return exparationDate;
    }

    public void setExparationDate(String exparationDate) {
        this.exparationDate = exparationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(BigDecimal addAmount) {
        this.addAmount = addAmount;
    }

    public String getFromUid() {
        return fromUid;
    }

    public void setFromUid(String fromUid) {
        this.fromUid = fromUid;
    }
}
