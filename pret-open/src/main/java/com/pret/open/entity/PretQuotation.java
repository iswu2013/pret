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
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 报价</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_quotation")
@Excel("报价")
@Data
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
     * 计费区间id
     */
    @ExcelField(value = "计费区间id")
    private String billingIntervalId;

    /**
     * 报价开始日期
     */
    @ExcelField(value = "报价开始日期", writeConverter = TimeConverter.class)
    private Date periodFrom;

    /**
     * 报价截止日期
     */
    @ExcelField(value = "报价截止日期", writeConverter = TimeConverter.class)
    private Date periodTo;

    /**
     * 状态
     */
    @ExcelField(value = "状态")
    private int status = ConstantEnum.ECheckStatus.待审核.getLabel();

    /**
     * 创建人
     */
    @ExcelField(value = "创建人")
    private String username;

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
     * 计费区间
     */
    private PretBillingInterval pretBillingInterval;

    /**
     * 报价明细
     */
    private List<PretQuotationItem> pretQuotationItemList;

    /**
     * 供应商
     */
    private PretVender pretVender;



    // setter and getter

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
    public PretBillingInterval getPretBillingInterval() {
        return pretBillingInterval;
    }

    public void setPretBillingInterval(PretBillingInterval pretBillingInterval) {
        this.pretBillingInterval = pretBillingInterval;
    }
}
