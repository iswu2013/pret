package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_quotation_item")
public class PretQuotationItem extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 报价id
     */
    private String quotationId;

    /**
     * 线路id
     */
    private String serviceRouteItem;
    /**
     * 起运地id
     */
    private String serviceRouteOriginId;
    /**
     * 线路明细id
     */
    private String serviceRouteItemId;
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

    /**
     * <p>Discription:[供应商id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getVenderId() {
        return venderId;
    }

    /**
     * <p>Discription:[供应商id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    /**
     * <p>Discription:[报价id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getQuotationId() {
        return quotationId;
    }

    public String getServiceRouteItem() {
        return serviceRouteItem;
    }

    public void setServiceRouteItem(String serviceRouteItem) {
        this.serviceRouteItem = serviceRouteItem;
    }

    /**
     * <p>Discription:[报价id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteOriginId() {
        return serviceRouteOriginId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteOriginId(String serviceRouteOriginId) {
        this.serviceRouteOriginId = serviceRouteOriginId;
    }

    /**
     * <p>Discription:[线路明细id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteItemId() {
        return serviceRouteItemId;
    }

    /**
     * <p>Discription:[线路明细id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteItemId(String serviceRouteItemId) {
        this.serviceRouteItemId = serviceRouteItemId;
    }

    /**
     * <p>Discription:[计费区间项id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getBillingIntervalItemId() {
        return billingIntervalItemId;
    }

    /**
     * <p>Discription:[计费区间项id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setBillingIntervalItemId(String billingIntervalItemId) {
        this.billingIntervalItemId = billingIntervalItemId;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public java.math.BigDecimal getQuotation() {
        return quotation;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotation(java.math.BigDecimal quotation) {
        this.quotation = quotation;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCostType() {
        return costType;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCostType(Integer costType) {
        this.costType = costType;
    }
}
