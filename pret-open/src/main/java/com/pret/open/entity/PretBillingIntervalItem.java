package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
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
@Table(name = "pret_billing_interval_item")
@Excel("计费区间项")
public class PretBillingIntervalItem extends VersionedAuditableIdEntity implements Serializable {

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
     * 0重货
     * 1泡货
     */
    @ExcelField(value = "货物类型", writeConverterExp = "0=重货,1=泡货")
    private Integer type;
    /**
     * 计费区间id
     */
    private String billingIntervalId;
    /**
     * 计费起始量
     */
    @ExcelField(value = "计费起始量")
    private Float start;
    /**
     * 计费结束量
     */
    @ExcelField(value = "计费结束量")
    private Float end;
    /**
     * 描述
     */
    @ExcelField(value = "描述")
    private String description;

    /**
     * 单位1公斤2吨3立方米
     */
    @ExcelField(value = "单位", writeConverterExp = "1=公斤,2=吨,3=立方米")
    private int unit;

    // setter and getter

    /**
     * <p>Discription:[1重货
     * 2泡货]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getType() {
        return type;
    }

    /**
     * <p>Discription:[1重货
     * 2泡货]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * <p>Discription:[计费区间id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getBillingIntervalId() {
        return billingIntervalId;
    }

    /**
     * <p>Discription:[计费区间id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setBillingIntervalId(String billingIntervalId) {
        this.billingIntervalId = billingIntervalId;
    }

    public Float getStart() {
        return start;
    }

    public void setStart(Float start) {
        this.start = start;
    }

    public Float getEnd() {
        return end;
    }

    public void setEnd(Float end) {
        this.end = end;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
