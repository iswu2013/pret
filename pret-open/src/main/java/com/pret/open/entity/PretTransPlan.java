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
@Table(name = "pret_trans_plan")
@Excel("运输计划")
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
    private String orginId;
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

    /**
     * 提货工厂
     */
    private String pickupFactoryCd;

    /**
     * 签收日期
     */
    @ExcelField(value = "签收日期", writeConverter = TimeConverter.class)
    private Date signDatetime;

    /**
     * 送达日期
     */
    private Date deliveryDate;

    // setter and getter

    /**
     * <p>Discription:[单号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getNo() {
        return no;
    }

    /**
     * <p>Discription:[单号]</p>
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
     * <p>Discription:[客户id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * <p>Discription:[客户id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * <p>Discription:[预计提货日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getTransDatetime() {
        return transDatetime;
    }

    /**
     * <p>Discription:[预计提货日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransDatetime(Date transDatetime) {
        this.transDatetime = transDatetime;
    }

    /**
     * <p>Discription:[原始运输计划id,针对异常退货]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrginId() {
        return orginId;
    }

    /**
     * <p>Discription:[原始运输计划id,针对异常退货]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrginId(String orginId) {
        this.orginId = orginId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    /**
     * <p>Discription:[目的地id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDestId() {
        return destId;
    }

    /**
     * <p>Discription:[目的地id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDestId(String destId) {
        this.destId = destId;
    }

    /**
     * <p>Discription:[目的地]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDestAddress() {
        return destAddress;
    }

    /**
     * <p>Discription:[目的地]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }

    /**
     * <p>Discription:[司机id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * <p>Discription:[司机id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Integer getGw() {
        return gw;
    }

    public void setGw(Integer gw) {
        this.gw = gw;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public float getCbm() {
        return cbm;
    }

    public void setCbm(float cbm) {
        this.cbm = cbm;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    /**
     * <p>Discription:[线路明细id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteItemId() {
        return serviceRouteItemId;
    }

    /**
     * <p>Discription:[线路明细id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteItemId(String serviceRouteItemId) {
        this.serviceRouteItemId = serviceRouteItemId;
    }

    /**
     * <p>Discription:[报价明细id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getQuotationItemId() {
        return quotationItemId;
    }

    /**
     * <p>Discription:[报价明细id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotationItemId(String quotationItemId) {
        this.quotationItemId = quotationItemId;
    }

    /**
     * <p>Discription:[运输费用id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransFeeId() {
        return transFeeId;
    }

    /**
     * <p>Discription:[运输费用id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransFeeId(String transFeeId) {
        this.transFeeId = transFeeId;
    }

    /**
     * <p>Discription:[异常id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransExceptionId() {
        return transExceptionId;
    }

    /**
     * <p>Discription:[异常id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransExceptionId(String transExceptionId) {
        this.transExceptionId = transExceptionId;
    }

    /**
     * <p>Discription:[状态(运输中,已签收)]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * <p>Discription:[状态(运输中,已签收)]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * <p>Discription:[费用创建人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getFeeConfirmBy() {
        return feeConfirmBy;
    }

    /**
     * <p>Discription:[费用创建人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setFeeConfirmBy(String feeConfirmBy) {
        this.feeConfirmBy = feeConfirmBy;
    }

    /**
     * <p>Discription:[费用创建日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getFeeConfirmDate() {
        return feeConfirmDate;
    }

    /**
     * <p>Discription:[费用创建日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setFeeConfirmDate(Date feeConfirmDate) {
        this.feeConfirmDate = feeConfirmDate;
    }

    /**
     * <p>Discription:[创建人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * <p>Discription:[创建人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getMailno() {
        return mailno;
    }

    public void setMailno(String mailno) {
        this.mailno = mailno;
    }

    public String getDesctcode() {
        return desctcode;
    }

    public void setDesctcode(String desctcode) {
        this.desctcode = desctcode;
    }

    public String getPickupFactoryCd() {
        return pickupFactoryCd;
    }

    public void setPickupFactoryCd(String pickupFactoryCd) {
        this.pickupFactoryCd = pickupFactoryCd;
    }

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

    public Date getSignDatetime() {
        return signDatetime;
    }

    public void setSignDatetime(Date signDatetime) {
        this.signDatetime = signDatetime;
    }

    public Integer getRealNum() {
        return realNum;
    }

    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
