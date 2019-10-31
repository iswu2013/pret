package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pret_trans_statement")
@Excel("对账单")
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

    private PretVender pretVender;

    // setter and getter


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    /**
     * <p>Discription:[收款人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getBillToId() {
        return billToId;
    }

    /**
     * <p>Discription:[收款人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setBillToId(String billToId) {
        this.billToId = billToId;
    }

    /**
     * <p>Discription:[付款人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPayById() {
        return payById;
    }

    /**
     * <p>Discription:[付款人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPayById(String payById) {
        this.payById = payById;
    }

    /**
     * <p>Discription:[对账日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getCheckDate() {
        return checkDate;
    }

    /**
     * <p>Discription:[对账日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCheckDate(java.util.Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * <p>Discription:[对账开始日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getPeriodFrom() {
        return periodFrom;
    }

    /**
     * <p>Discription:[对账开始日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPeriodFrom(java.util.Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    /**
     * <p>Discription:[ 对账截止日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getPeriodTo() {
        return periodTo;
    }

    /**
     * <p>Discription:[ 对账截止日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPeriodTo(java.util.Date periodTo) {
        this.periodTo = periodTo;
    }

    /**
     * <p>Discription:[费用总额]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public java.math.BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * <p>Discription:[费用总额]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public java.math.BigDecimal getPenIndAmount() {
        return penIndAmount;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPenIndAmount(java.math.BigDecimal penIndAmount) {
        this.penIndAmount = penIndAmount;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    /**
     * <p>Discription:[币别]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCurrencyId() {
        return currencyId;
    }

    /**
     * <p>Discription:[币别]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    /**
     * <p>Discription:[0待确认1通过2不通过3已转u9]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <p>Discription:[0待确认1通过2不通过3已转u9]</p>
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
}
