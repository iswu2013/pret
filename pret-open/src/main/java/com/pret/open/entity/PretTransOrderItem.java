package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: 运输单项</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_order_item")
@Excel("运输单项")
@Data
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

    private PretTransOrder pretTransOrder;

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
}
