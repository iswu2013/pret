package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretTransStatementBo  {
    private String ids;

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
    private String periodFromStr;
    /**
     * 对账截止日期
     */
    private String periodToStr;
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

    // setter and getter


    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
}
