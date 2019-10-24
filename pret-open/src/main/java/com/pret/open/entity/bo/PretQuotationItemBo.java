package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretQuotationItemBo {
    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 报价id
     */
    private String quotationId;
    /**
     * 起运地id
     */
    private String serviceRouteOriginId;
    /**
     * 线路明细id
     */
    private String serviceRouteItemId;

    /**
     * 线路id
     */
    private String serviceRouteId;
    /**
     * 计费区间项id
     */
    private String billingIntervalItemId;
    /**
     * 报价
     */
    private BigDecimal quotation;
    /**
     * 价格类型(0量1票)
     */
    private Integer costType = ConstantEnum.ECostType.量.getLabel();

    // setter and getter

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getServiceRouteOriginId() {
        return serviceRouteOriginId;
    }

    public void setServiceRouteOriginId(String serviceRouteOriginId) {
        this.serviceRouteOriginId = serviceRouteOriginId;
    }

    public String getServiceRouteId() {
        return serviceRouteId;
    }

    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    public String getServiceRouteItemId() {
        return serviceRouteItemId;
    }

    public void setServiceRouteItemId(String serviceRouteItemId) {
        this.serviceRouteItemId = serviceRouteItemId;
    }

    public String getBillingIntervalItemId() {
        return billingIntervalItemId;
    }

    public void setBillingIntervalItemId(String billingIntervalItemId) {
        this.billingIntervalItemId = billingIntervalItemId;
    }

    public BigDecimal getQuotation() {
        return quotation;
    }

    public void setQuotation(BigDecimal quotation) {
        this.quotation = quotation;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }
}
