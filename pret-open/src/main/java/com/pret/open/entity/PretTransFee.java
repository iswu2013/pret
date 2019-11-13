package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description: 运输费用</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_fee")
@Excel("运输费用")
@Data
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
    private String transPlanId;

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
