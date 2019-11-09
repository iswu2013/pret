package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretQuotationBo  {

    private String id;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 线路明细id
     */
    private String serviceRouteItemId;

    /**
     * 报价开始日期
     */
    private String periodFromStr;
    /**
     * 报价截止日期
     */
    private String periodToStr;

    /**
     * 报价明细
     */
    private String pretQuotationItemStr;

    /**
     * 计费区间
     */
    private String billingIntervalId;

    /**
     * 创建用户
     */
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getServiceRouteItemId() {
        return serviceRouteItemId;
    }

    public void setServiceRouteItemId(String serviceRouteItemId) {
        this.serviceRouteItemId = serviceRouteItemId;
    }

    public String getPeriodFromStr() {
        return periodFromStr;
    }

    public void setPeriodFromStr(String periodFromStr) {
        this.periodFromStr = periodFromStr;
    }

    public String getPeriodToStr() {
        return periodToStr;
    }

    public void setPeriodToStr(String periodToStr) {
        this.periodToStr = periodToStr;
    }

    public String getPretQuotationItemStr() {
        return pretQuotationItemStr;
    }

    public void setPretQuotationItemStr(String pretQuotationItemStr) {
        this.pretQuotationItemStr = pretQuotationItemStr;
    }

    public String getBillingIntervalId() {
        return billingIntervalId;
    }

    public void setBillingIntervalId(String billingIntervalId) {
        this.billingIntervalId = billingIntervalId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
