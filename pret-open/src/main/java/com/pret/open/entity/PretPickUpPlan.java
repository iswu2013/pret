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
@Table(name = "pret_pick_up_plan")
public class PretPickUpPlan extends VersionedAuditableIdEntity implements Serializable {

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
     * 编号
     */
    private String no;
    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 类型
     */
    private String type;
    /**
     * 预计提货时间
     */
    private java.util.Date pickUpTime;
    /**
     *
     */
    private String driverId;
    /**
     * 提货数量
     */
    private Integer count;
    /**
     * 提货重量
     */
    private String weight;
    /**
     * 0待提货1已完成
     */
    private Integer status;
    /**
     * 实际提货时间
     */
    private java.util.Date startTime;
    /**
     * 结束提货时间
     */
    private java.util.Date endTime;

    // setter and getter

    /**
     * <p>Discription:[编号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getNo() {
        return no;
    }

    /**
     * <p>Discription:[编号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setNo(String no) {
        this.no = no;
    }

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
     * <p>Discription:[类型]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getType() {
        return type;
    }

    /**
     * <p>Discription:[类型]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <p>Discription:[预计提货时间]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getPickUpTime() {
        return pickUpTime;
    }

    /**
     * <p>Discription:[预计提货时间]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPickUpTime(java.util.Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    /**
     * <p>Discription:[提货数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCount() {
        return count;
    }

    /**
     * <p>Discription:[提货数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * <p>Discription:[提货重量]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getWeight() {
        return weight;
    }

    /**
     * <p>Discription:[提货重量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * <p>Discription:[0待提货1已完成]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <p>Discription:[0待提货1已完成]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <p>Discription:[实际提货时间]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getStartTime() {
        return startTime;
    }

    /**
     * <p>Discription:[实际提货时间]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    /**
     * <p>Discription:[结束提货时间]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getEndTime() {
        return endTime;
    }

    /**
     * <p>Discription:[结束提货时间]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
}
