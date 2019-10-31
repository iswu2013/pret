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
@Table(name = "pret_pick_up_plan_item")
@Excel("提货计划项")
public class PretPickUpPlanItem extends VersionedAuditableIdEntity implements Serializable {

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
     * 提货计划id
     */
    @ExcelField(value = "提货计划id")
    private String pickUpPlanId;
    /**
     * 配送单id
     */
    @ExcelField(value = "配送单id")
    private String deliveryOrderId;

    // setter and getter

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
     * <p>Discription:[配送单id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDeliveryOrderId() {
        return deliveryOrderId;
    }

    /**
     * <p>Discription:[配送单id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDeliveryOrderId(String deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }
}
