package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
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
@Table(name = "pret_trans_fee")
@Excel("运输费用")
public class PretTransFee extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    /**
     * 单号
     */
    @ExcelField(value = "单号")
    private String no;

    /**
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;
    /**
     * 运输计划id
     */
    @ExcelField(value = "运输计划id")
    private String transPanId;
    /**
     * 客户id
     */
    @ExcelField(value = "客户id")
    private String customerId;
    /**
     * 对账单id
     */
    @ExcelField(value = "对账单id")
    private String transStatementId;
    /**
     * 送货单数量
     */
    @ExcelField(value = "送货单数量")
    private Integer tOrderCount;
    /**
     * 计费数量
     */
    @ExcelField(value = "计费数量")
    private Integer quotationCount;
    /**
     * 单价
     */
    @ExcelField(value = "单价")
    private BigDecimal unitPrice;
    /**
     * 总金额
     */
    @ExcelField(value = "总金额")
    private BigDecimal quotation;
    /**
     * 状态(待审核,通过,不通过)
     */
    @ExcelField(value = "状态", writeConverterExp = "0=待审核,1=通过,2=不通过")
    private Integer status;

    private PretVender pretVender;

    private PretCustomer pretCustomer;

    // setter and getter


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Column(name = "t_order_count")
    public Integer gettOrderCount() {
        return tOrderCount;
    }

    public void settOrderCount(Integer tOrderCount) {
        this.tOrderCount = tOrderCount;
    }

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
     * <p>Discription:[运输计划id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransPanId() {
        return transPanId;
    }

    /**
     * <p>Discription:[运输计划id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransPanId(String transPanId) {
        this.transPanId = transPanId;
    }

    /**
     * <p>Discription:[客户id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * <p>Discription:[客户id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * <p>Discription:[对账单id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransStatementId() {
        return transStatementId;
    }

    /**
     * <p>Discription:[对账单id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransStatementId(String transStatementId) {
        this.transStatementId = transStatementId;
    }

    /**
     * <p>Discription:[送货单数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getTOrderCount() {
        return tOrderCount;
    }

    /**
     * <p>Discription:[送货单数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTOrderCount(Integer tOrderCount) {
        this.tOrderCount = tOrderCount;
    }

    /**
     * <p>Discription:[计费数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getQuotationCount() {
        return quotationCount;
    }

    /**
     * <p>Discription:[计费数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotationCount(Integer quotationCount) {
        this.quotationCount = quotationCount;
    }

    /**
     * <p>Discription:[单价]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * <p>Discription:[单价]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * <p>Discription:[总金额]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public BigDecimal getQuotation() {
        return quotation;
    }

    /**
     * <p>Discription:[总金额]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotation(BigDecimal quotation) {
        this.quotation = quotation;
    }

    /**
     * <p>Discription:[状态(待审核,通过,不通过)]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <p>Discription:[状态(待审核,通过,不通过)]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretCustomer getPretCustomer() {
        return pretCustomer;
    }

    public void setPretCustomer(PretCustomer pretCustomer) {
        this.pretCustomer = pretCustomer;
    }
}
