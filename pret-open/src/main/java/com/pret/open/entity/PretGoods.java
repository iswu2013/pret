package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 商品</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_goods")
@Excel("商品")
@Data
public class PretGoods extends VersionedAuditableIdEntity implements Serializable {

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
     * 料号
     */
    @ExcelField(value = "料号")
    private String partNo;

    /**
     * 批号
     */
    @ExcelField(value = "批号")
    private String batchNo;

    /**
     * 品名
     */
    @ExcelField(value = "品名")
    private String product;

    /**
     * 商品重量
     */
    @ExcelField(value = "商品重量")
    private Float weight;

    /**
     * 商品单位
     */
    @ExcelField(value = "商品单位")
    private Integer unit;

    // setter and getter
}
