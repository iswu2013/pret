package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 运输计划</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_plan")
@Excel("运输计划")
@Data
public class PretTransPlan extends VersionedAuditableIdEntity implements Serializable {

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

    private Integer type = ConstantEnum.EPretTransPlanType.正常运输.getLabel();

    /**
     * 单号
     */
    @ExcelField(value = "单号")
    private String no;

    /**
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;

    /**
     * 客户id
     */
    @ExcelField(value = "客户id")
    private String customerId;

    /**
     * 预计提货日期
     */
    @ExcelField(value = "预计提货时间", writeConverter = TimeConverter.class)
    private Date transDatetime;

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
    @ExcelField(value = "起运地")
    private String orgAddress;

    /**
     * 目的地id
     */
    private String destId;

    /**
     * 目的地
     */
    @ExcelField(value = "目的地")
    private String destAddress;

    /**
     * 司机id
     */
    @ExcelField(value = "司机id")
    private String driverId;

    /**
     * 商品重量
     */
    @ExcelField(value = "商品重量")
    private Integer gw;

    /**
     * 单位(1吨，2公斤)
     */
    @ExcelField(value = "单位", writeConverterExp = "1=吨,2=公斤")
    private int unit;

    /**
     * 立方体积
     */
    @ExcelField(value = "立方体积")
    private float cbm;

    /**
     * 货物件数
     */
    @ExcelField(value = "货物件数")
    private int goodsNum;

    /**
     *
     */
    @ExcelField(value = "实际数量")
    private Integer realNum;

    /**
     * 线路明细id
     */
    @ExcelField(value = "线路明细id")
    private String serviceRouteItemId;

    /**
     * 报价明细id
     */
    @ExcelField(value = "报价明细id")
    private String quotationItemId;

    /**
     * 运输费用id
     */
    @ExcelField(value = "运输费用id")
    private String transFeeId;

    /**
     * 异常id
     */
    @ExcelField(value = "异常id")
    private String transExceptionId;

    /**
     * 状态(运输中,已签收)
     */
    @ExcelField(value = "状态", writeConverterExp = "1=运输中,2=已签收")
    private Integer status = ConstantEnum.ETransPlanStatus.运输中.getValue();

    /**
     * 费用创建人
     */
    @ExcelField(value = "费用创建人")
    private String feeConfirmBy;

    /**
     * 费用创建日期
     */
    @ExcelField(value = "费用创建日期", writeConverter = TimeConverter.class)
    private Date feeConfirmDate;

    /**
     * 创建人
     */
    @ExcelField(value = "创建人")
    private String createBy;

    /**
     * 快递单号
     */
    @ExcelField(value = "快递单号")
    private String mailno;

    /**
     * 顺丰目的地码
     */
    @ExcelField(value = "顺丰目的地码")
    private String desctcode;

    /**
     * 提货工厂
     */
    @ExcelField(value = "提货工厂")
    private String pickupFactoryCd;

    /**
     * 签收日期
     */
    @ExcelField(value = "签收日期", writeConverter = TimeConverter.class)
    private Date signDatetime;

    /**
     * 送达日期
     */
    @ExcelField(value = "送达日期", writeConverter = TimeConverter.class)
    private Date deliveryDate;

    private PretVender pretVender;

    private PretCustomer pretCustomer;

    /**
     * 从运输任务单中获取一些信息
     */
    private PretTransOrder pretTransOrder;

    /**
     * 司机信息
     */
    private PretDriver pretDriver;

    // setter and getter

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretCustomer getPretCustomer() {
        return pretCustomer;
    }

    public void setPretCustomer(PretCustomer pretCustomer) {
        this.pretCustomer = pretCustomer;
    }

    @Transient()
    public PretTransOrder getPretTransOrder() {
        return pretTransOrder;
    }

    public void setPretTransOrder(PretTransOrder pretTransOrder) {
        this.pretTransOrder = pretTransOrder;
    }

    @Transient()
    public PretDriver getPretDriver() {
        return pretDriver;
    }

    public void setPretDriver(PretDriver pretDriver) {
        this.pretDriver = pretDriver;
    }
}
