package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: 运输计划</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransPlanBo {
    /**
     * 订单id
     */
    private String ids;

    /**
     * 提货计划ids
     */
    private String pickUpIds;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 客户id
     */
    private String customerId;
    /**
     * 预计提货日期
     */
    private java.util.Date transDatetime;
    /**
     * 原始运输计划id,针对异常退货
     */
    private String originId;
    /**
     * 起运地id
     */
    private String orgId;
    /**
     * 起运地
     */
    private String orgAddress;
    /**
     * 目的地id
     */
    private String destId;
    /**
     * 目的地
     */
    private String destAddress;
    /**
     * 司机id
     */
    private String driverId;
    /**
     * 提货数量
     */
    private Integer count;
    /**
     * 重物数量
     */
    private Integer gw;
    /**
     * 重物单位重
     */
    private String cbm;
    /**
     * 泡物数量
     */
    private Integer cw;
    /**
     * 泡物单位立方
     */
    private String unit;

    /**
     * 操作人
     */
    private String username;

    // setter and getter
}
