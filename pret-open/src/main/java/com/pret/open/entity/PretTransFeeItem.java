package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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
    @ExcelField(value = "供应商")
    private String venderId;

    /**
     * 运输单费用id
     */
    @ExcelField(value = "运输单费用")
    private String transFeeId;

    /**
     * 费用类别
     */
    @ExcelField(value = "状态", writeConverterExp = "1=运费,2=罚款,3=赔款")
    private String feeTypeId;

    /**
     * 单价
     */
    @ExcelField(value = "单价")
    private BigDecimal unitPrice;

    /**
     * 金额
     */
    @ExcelField(value = "金额")
    private BigDecimal quotation;

    /**
     * 备注
     */
    private String remark;
    /**
     *
     */
    private String createBy;

    /**
     * 费用描述，针对自定义费用
     */
    private String name;

    /**
     * 费用类别，针对自定义费用
     */
    private String feeType;

    private Float quotationCount;

    /**
     * 计费类别0自动计费1手动计费
     */
    private Integer calType = ConstantEnum.ECalType.自动计费.getLabel();

    /**
     * 是否是异常费用
     */
    private Integer exceptionFee = ConstantEnum.EYesOrNo.否.getLabel();

    private PretFeeType pretFeeType;

    // setter and getter


    @Transient()
    public PretFeeType getPretFeeType() {
        return pretFeeType;
    }

    public void setPretFeeType(PretFeeType pretFeeType) {
        this.pretFeeType = pretFeeType;
    }
}
