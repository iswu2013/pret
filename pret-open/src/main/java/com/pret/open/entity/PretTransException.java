package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
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
@Table(name = "pret_trans_exception")
public class PretTransException extends VersionedAuditableIdEntity implements Serializable {

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
     * 单号
     */
    private String no;

    /**
     * 运输计划id
     */
    private String transPlanId;
    /**
     * 运输任务单明细id
     */
    private String transOrderId;
    /**
     * 异常类别0
     */
    private Integer type;
    /**
     * 状态0待审核1通过2不通过
     */
    private Integer status = ConstantEnum.ECheckStatus.待审核.getLabel();
    /**
     * 处理方式
     */
    private Integer handleStyle;
    /**
     * 异常描述
     */
    private String remark;
    /**
     * 图片id
     */
    private String picIds;
    /**
     * 异常数量
     */
    private Integer count;
    /**
     * 责任方0物流1货主2客户
     */
    private Integer responsibleParty;
    /**
     * 处理时间
     */
    private java.util.Date handleTime;
    /**
     * 处理人
     */
    private String handleBy;

    /**
     * 物流供应商
     */
    private String venderId;

    @Transient()
    private PretVender pretVender;

    @Transient()
    private PretTransPlan pretTransPlan;

    @Transient()
    private PretTransOrder pretTransOrder;

    // setter and getter


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getTransOrderId() {
        return transOrderId;
    }

    public void setTransOrderId(String transOrderId) {
        this.transOrderId = transOrderId;
    }

    /**
     * <p>Discription:[异常类别0]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getType() {
        return type;
    }

    /**
     * <p>Discription:[异常类别0]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * <p>Discription:[状态0待审核1通过2不通过]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <p>Discription:[状态0待审核1通过2不通过]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <p>Discription:[处理方式]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getHandleStyle() {
        return handleStyle;
    }

    /**
     * <p>Discription:[处理方式]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setHandleStyle(Integer handleStyle) {
        this.handleStyle = handleStyle;
    }

    /**
     * <p>Discription:[异常描述]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>Discription:[异常描述]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>Discription:[图片id	]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPicIds() {
        return picIds;
    }

    /**
     * <p>Discription:[图片id	]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPicIds(String picIds) {
        this.picIds = picIds;
    }

    /**
     * <p>Discription:[异常数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCount() {
        return count;
    }

    /**
     * <p>Discription:[异常数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * <p>Discription:[责任方0物流1货主2客户]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getResponsibleParty() {
        return responsibleParty;
    }

    /**
     * <p>Discription:[责任方0物流1货主2客户]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setResponsibleParty(Integer responsibleParty) {
        this.responsibleParty = responsibleParty;
    }

    /**
     * <p>Discription:[处理时间]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getHandleTime() {
        return handleTime;
    }

    /**
     * <p>Discription:[处理时间]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setHandleTime(java.util.Date handleTime) {
        this.handleTime = handleTime;
    }

    /**
     * <p>Discription:[处理人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getHandleBy() {
        return handleBy;
    }

    /**
     * <p>Discription:[处理人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setHandleBy(String handleBy) {
        this.handleBy = handleBy;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    public PretTransPlan getPretTransPlan() {
        return pretTransPlan;
    }

    public void setPretTransPlan(PretTransPlan pretTransPlan) {
        this.pretTransPlan = pretTransPlan;
    }

    public PretTransOrder getPretTransOrder() {
        return pretTransOrder;
    }

    public void setPretTransOrder(PretTransOrder pretTransOrder) {
        this.pretTransOrder = pretTransOrder;
    }
}
