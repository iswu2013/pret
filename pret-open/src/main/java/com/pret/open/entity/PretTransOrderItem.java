package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pret_trans_order_item")
public class PretTransOrderItem extends VersionedAuditableIdEntity implements Serializable {

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
     * 运输任务单id
     */
    private String transOrderId;
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 提货计划id
     */
    private String pickUpPlanId;
    /**
     * 运输计划id
     */
    private String transPlanId;
    /**
     * 商品数量
     */
    private Integer count;
    /**
     * 商品重量/体积
     */
    private String cb;

    // setter and getter

    /**
     * <p>Discription:[运输任务单id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransOrderId() {
        return transOrderId;
    }

    /**
     * <p>Discription:[运输任务单id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransOrderId(String transOrderId) {
        this.transOrderId = transOrderId;
    }

    /**
     * <p>Discription:[商品id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getGoodsId() {
        return goodsId;
    }

    /**
     * <p>Discription:[商品id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * <p>Discription:[提货计划id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPickUpPlanId() {
        return pickUpPlanId;
    }

    /**
     * <p>Discription:[提货计划id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPickUpPlanId(String pickUpPlanId) {
        this.pickUpPlanId = pickUpPlanId;
    }

    /**
     * <p>Discription:[运输计划id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransPlanId() {
        return transPlanId;
    }

    /**
     * <p>Discription:[运输计划id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransPlanId(String transPlanId) {
        this.transPlanId = transPlanId;
    }

    /**
     * <p>Discription:[商品数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCount() {
        return count;
    }

    /**
     * <p>Discription:[商品数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * <p>Discription:[商品重量/体积]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCb() {
        return cb;
    }

    /**
     * <p>Discription:[商品重量/体积]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCb(String cb) {
        this.cb = cb;
    }
}
