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
import java.math.BigDecimal;

/**
 * <p>Description: 运输费用项</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_fee_item")
@Excel("运输费用项")
@Data
public class PretTransFeeItem extends VersionedAuditableIdEntity implements Serializable {

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
    @ExcelField(value = "总金额")
    private String venderId;

    /**
     * 运输单费用id
     */
    @ExcelField(value = "总金额")
    private String transFeeId;

    /**
     * 1运费2罚款3赔款
     */
    @ExcelField(value = "状态", writeConverterExp = "1=运费,2=罚款,3=赔款")
    private Integer type;

    /**
     * 运输计划id
     */
    @ExcelField(value = "总金额")
    private String transPlanId;

    /**
     * 计费数量
     */
    @ExcelField(value = "总金额")
    private Integer quotationCount;

    /**
     * 单价
     */
    @ExcelField(value = "总金额")
    private java.math.BigDecimal unitPrice;

    /**
     * 金额
     */
    @ExcelField(value = "总金额")
    private BigDecimal quotation;

    /**
     * 备注
     */
    private String remark;
    /**
     *
     */
    private String createBy;

    // setter and getter
}
