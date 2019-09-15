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
@Table(name = "pret_billing_interval_item")
public class PretBillingIntervalItem extends VersionedAuditableIdEntity implements Serializable {

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
    private String venderId;
    /**
     * 1重货
     * 2泡货
     */
    private Integer type;
    /**
     * 计费区间id
     */
    private String billingIntervalId;
    /**
     * 计费起始量
     */
    private String start;
    /**
     * 计费结束量
     */
    private String end;
    /**
     * 描述
     */
    private String description;

    // setter and getter

    /**
     * <p>Discription:[供应商id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getVenderId() {
        return venderId;
    }

    /**
     * <p>Discription:[供应商id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    /**
     * <p>Discription:[1重货
     * 2泡货]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getType() {
        return type;
    }

    /**
     * <p>Discription:[1重货
     * 2泡货]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * <p>Discription:[计费区间id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getBillingIntervalId() {
        return billingIntervalId;
    }

    /**
     * <p>Discription:[计费区间id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setBillingIntervalId(String billingIntervalId) {
        this.billingIntervalId = billingIntervalId;
    }

    /**
     * <p>Discription:[计费起始量]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getStart() {
        return start;
    }

    /**
     * <p>Discription:[计费起始量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * <p>Discription:[计费结束量]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getEnd() {
        return end;
    }

    /**
     * <p>Discription:[计费结束量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
