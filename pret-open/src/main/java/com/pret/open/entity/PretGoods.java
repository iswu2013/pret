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
@Table(name = "pret_goods")
@Excel("商品")
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
    private String weight;
    /**
     * 商品单位
     */
    @ExcelField(value = "商品单位")
    private Integer unit;

    // setter and getter

    /**
     * <p>Discription:[料号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPartNo() {
        return partNo;
    }

    /**
     * <p>Discription:[料号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    /**
     * <p>Discription:[批号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * <p>Discription:[批号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    /**
     * <p>Discription:[品名]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getProduct() {
        return product;
    }

    /**
     * <p>Discription:[品名]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * <p>Discription:[商品重量]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getWeight() {
        return weight;
    }

    /**
     * <p>Discription:[商品重量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * <p>Discription:[商品单位]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getUnit() {
        return unit;
    }

    /**
     * <p>Discription:[商品单位]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
