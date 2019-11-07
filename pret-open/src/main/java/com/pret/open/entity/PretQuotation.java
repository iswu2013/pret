package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
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
@Table(name = "pret_quotation")
@Excel("报价")
public class PretQuotation extends VersionedAuditableIdEntity implements Serializable {

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
     * 报价单号
     */
    @ExcelField(value = "报价单号")
    private String no;

    /**
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;
    /**
     * 线路id
     */
    @ExcelField(value = "线路id")
    private String serviceRouteId;

    /**
     * 区间id
     */
    @ExcelField(value = "区间id")
    private String billingIntervalId;

    /**
     * 计费区间
     */
    private PretBillingInterval pretBillingInterval;

    /**
     * 报价开始日期
     */
    @ExcelField(value = "对账开始日期", writeConverter = TimeConverter.class)
    private Date periodFrom;
    /**
     * 报价截止日期
     */
    @ExcelField(value = "对账截止日期", writeConverter = TimeConverter.class)
    private Date periodTo;

    /**
     * 状态
     */
    @ExcelField(value = "状态")
    private int status = ConstantEnum.ECheckStatus.待审核.getLabel();

    /**
     * 审核人
     */
    @ExcelField(value = "审核人")
    private String checkUserId;

    /**
     * 审核日期
     */
    @ExcelField(value = "审核日期", writeConverter = TimeConverter.class)
    private Date checkDate;

    /**
     * 报价明细
     */
    private List<PretQuotationItem> pretQuotationItemList;

    /**
     * 供应商
     */
    private PretVender pretVender;

    /**
     * 线路
     */
    private PretServiceRoute pretServiceRoute;

    /**
     * 线路名称
     */
    private String serviceRouteNames;

    // setter and getter


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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
     * <p>Discription:[线路id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteId() {
        return serviceRouteId;
    }

    /**
     * <p>Discription:[线路id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(Date periodTo) {
        this.periodTo = periodTo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    @Transient()
    public String getServiceRouteNames() {
        return serviceRouteNames;
    }

    public void setServiceRouteNames(String serviceRouteNames) {
        this.serviceRouteNames = serviceRouteNames;
    }

    @Transient()
    public List<PretQuotationItem> getPretQuotationItemList() {
        return pretQuotationItemList;
    }

    public void setPretQuotationItemList(List<PretQuotationItem> pretQuotationItemList) {
        this.pretQuotationItemList = pretQuotationItemList;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretServiceRoute getPretServiceRoute() {
        return pretServiceRoute;
    }

    public void setPretServiceRoute(PretServiceRoute pretServiceRoute) {
        this.pretServiceRoute = pretServiceRoute;
    }

    public String getBillingIntervalId() {
        return billingIntervalId;
    }

    public void setBillingIntervalId(String billingIntervalId) {
        this.billingIntervalId = billingIntervalId;
    }

    @Transient()
    public PretBillingInterval getPretBillingInterval() {
        return pretBillingInterval;
    }

    public void setPretBillingInterval(PretBillingInterval pretBillingInterval) {
        this.pretBillingInterval = pretBillingInterval;
    }
}
