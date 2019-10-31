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
@Table(name = "pret_quotation_item_price")
@Excel("报价项")
public class PretQuotationItemPrice extends VersionedAuditableIdEntity implements Serializable {

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
     *
     */
    @ExcelField(value = "数量")
    private Integer count;
    /**
     *
     */
    @ExcelField(value = "配送单id")
    private String deliveryOrderId;
    /**
     *
     */
    @ExcelField(value = "商品id")
    private String goodsId;
    /**
     *
     */
    @ExcelField(value = "重量")
    private String weight;

    // setter and getter

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCount() {
        return count;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDeliveryOrderId(String deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getWeight() {
        return weight;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }
}
