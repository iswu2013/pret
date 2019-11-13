package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 报价项</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_quotation_item")
@Excel("报价项")
@Data
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
    @ExcelField(value = "供应商id")
    private String venderId;

    /**
     * 报价id
     */
    @ExcelField(value = "报价id")
    private String quotationId;

    /**
     * 起运地id
     */
    @ExcelField(value = "起运地id")
    private String serviceRouteOriginId;

    /**
     * u9code
     */
    private String code;

    /**
     * 线路明细id
     */
    private String addressId;

    /**
     * 线路id
     */
    @ExcelField(value = "线路id")
    private String serviceRouteId;

    /**
     * 线路明细id
     */
    @ExcelField(value = "线路明细id")
    private String serviceRouteItemId;

    /**
     * 计费区间项
     */
    @ExcelField(value = "计费区间项")
    private String billingIntervalItemId;

    /**
     * 报价
     */
    @ExcelField(value = "报价")
    private BigDecimal quotation;

    /**
     * 费用类型
     */
    private String feeTypeId;

    // setter and getter
}
