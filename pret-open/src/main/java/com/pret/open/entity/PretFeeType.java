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
 * <p>Description: 费用类别</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_fee_type")
@Excel("费用类型")
@Data
public class PretFeeType extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    /**
     * 名称
     */
    @ExcelField(value = "名称")
    private String name;

    /**
     * 描述
     */
    @ExcelField(value = "描述")
    private String description;

    /**
     * 费用类型0票1量
     */
    @ExcelField(value = "货物类型", writeConverterExp = "0=票,1=量")
    private int type;

    /**
     * 商品类别,0重货，1泡货
     */
    @ExcelField(value = "商品类别", writeConverterExp = "0=重货,1=泡货")
    private int goodsType;
}
