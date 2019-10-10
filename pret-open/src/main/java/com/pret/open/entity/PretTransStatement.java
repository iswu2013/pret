package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String no;

    /**
     * 收款人
     */
    private String billToId;
    /**
     * 付款人
     */
    private String payById;
    /**
     * 对账日期
     */
    private java.util.Date checkDate;
    /**
     * 对账开始日期
     */
    private java.util.Date periodFrom;
    /**
     * 对账截止日期
     */
    private java.util.Date periodTo;
    /**
     * 费用总额
     */
    private java.math.BigDecimal totalAmount;
    /**
     *
     */
    private java.math.BigDecimal penIndAmount;
    /**
     *
     */
    private Long realAmount;
    /**
     * 币别
     */
    private String currencyId;
    /**
     * 0待确认1通过2不通过3已转u9
     */
    private Integer status;

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

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return Long
     * @author:wujinsong
     */
    public Long getRealAmount() {
        return realAmount;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setRealAmount(Long realAmount) {
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
}
