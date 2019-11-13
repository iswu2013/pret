package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: 计费区间项</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_billing_interval_item")
@Excel("计费区间项")
@Data
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
     * 公斤
     */
    private Float kstart;

    /**
     * 计费结束量
     */
    @ExcelField(value = "计费结束量")
    private Float end;

    /**
     * 公斤
     */
    private Float kend;

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
}
