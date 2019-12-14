package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.converter.TimeConverter;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 对账单</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_statement")
@Excel("对账单")
@Data
public class PretTransStatement extends VersionedAuditableIdEntity implements Serializable {

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
     * 单号
     */
    @ExcelField(value = "快递单号")
    private String no;

    /**
     * 收款人
     */
    @ExcelField(value = "快递单号")
    private String billToId;

    /**
     * 付款人
     */
    @ExcelField(value = "快递单号")
    private String payById;

    /**
     * 对账日期
     */
    @ExcelField(value = "对账日期", writeConverter = TimeConverter.class)
    private Date checkDate;

    /**
     * 对账开始日期
     */
    @ExcelField(value = "对账开始日期", writeConverter = TimeConverter.class)
    private Date periodFrom;

    /**
     * 对账截止日期
     */
    @ExcelField(value = "对账截止日期", writeConverter = TimeConverter.class)
    private Date periodTo;

    /**
     * 费用总额
     */
    @ExcelField(value = "费用总额")
    private BigDecimal totalAmount;

    private Float totalGw;

    /**
     *
     */
    private BigDecimal penIndAmount;
    /**
     *
     */
    private BigDecimal realAmount;
    /**
     * 币别
     */
    @ExcelField(value = "币别")
    private String currencyId;

    /**
     * 0待确认1通过2不通过3已转u9
     */
    @ExcelField(value = "状态", writeConverterExp = "0=待确认,1=通过,2=不通过,3=已转u9")
    private Integer status;

    private String deptId;

    private PretVender pretVender;

    private PretCurrency pretCurrency;

    private PretCustomer pretCustomer;

    private List<PretTransPlan> pretTransPlanList;

    private List<PretTransFee> pretTransFeeList;

    // setter and getter

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretCurrency getPretCurrency() {
        return pretCurrency;
    }

    public void setPretCurrency(PretCurrency pretCurrency) {
        this.pretCurrency = pretCurrency;
    }

    @Transient()
    public List<PretTransPlan> getPretTransPlanList() {
        return pretTransPlanList;
    }

    public void setPretTransPlanList(List<PretTransPlan> pretTransPlanList) {
        this.pretTransPlanList = pretTransPlanList;
    }

    @Transient()
    public List<PretTransFee> getPretTransFeeList() {
        return pretTransFeeList;
    }

    public void setPretTransFeeList(List<PretTransFee> pretTransFeeList) {
        this.pretTransFeeList = pretTransFeeList;
    }

    @Transient()
    public PretCustomer getPretCustomer() {
        return pretCustomer;
    }

    public void setPretCustomer(PretCustomer pretCustomer) {
        this.pretCustomer = pretCustomer;
    }
}
