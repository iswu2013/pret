package com.pret.api.info;

import java.math.BigDecimal;

/**
 * @author wujingsong
 * @title: BusinessWalletInfo
 * @projectName pert
 * @description: TODO
 * @date 2019-08-0722:34
 */
public class BusinessWalletInfo extends BaseInfo {
    private String id;

    private String busiId;

    private BigDecimal totalBalance;

    private BigDecimal availableBalance;

    private String aliAccount;

    private String aliName;

    private BigDecimal changeAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getAliAccount() {
        return aliAccount;
    }

    public void setAliAccount(String aliAccount) {
        this.aliAccount = aliAccount;
    }

    public String getAliName() {
        return aliName;
    }

    public void setAliName(String aliName) {
        this.aliName = aliName;
    }

    public BigDecimal getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(BigDecimal changeAmount) {
        this.changeAmount = changeAmount;
    }
}
