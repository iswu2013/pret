package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
     * 运输方式
     */
    @ExcelField(value = "运输方式")
    private String transModeCd;

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
     * 起运日期
     */
    @ExcelField(value = "起运日期", writeConverter = TimeConverter.class)
    private Date transDatetime;

    /**
     * 原始运输计划id,针对异常退货
     */
    private String originId;

    /**
     * 司机id
     */
    @ExcelField(value = "司机id")
    private String driverId;

    /**
     * 商品重量
     */
    @ExcelField(value = "商品重量")
    private Float gw;

    /**
     * 签收数量
     */
    private Float signGw;

    /**
     * 拒收数量
     */
    private Float rejectGw = 0f;


    /**
     * 立方体积
     */
    @ExcelField(value = "立方体积")
    private Float cbm;

    /**
     * 商品数量
     */
    @ExcelField(value = "商品数量")
    private Integer goodsNum;

    /**
     *
     */
    @ExcelField(value = "实际数量")
    private Float realNum;

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
    @ExcelField(value = "状态", writeConverterExp = "0=待起运,1=已起运,2=已签收")
    private Integer status = ConstantEnum.ETransPlanStatus.待起运.getValue();

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
     * 签收人
     */
    @ExcelField(value = "签收人")
    private String signUsername;

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

    @ExcelField(value = "预计送达日期", writeConverter = TimeConverter.class)
    private Date preDeliveryDate;

    /**
     * 提货地
     */
    @ExcelField(value = "提货地")
    private String serviceRouteOriginName;

    /**
     * 提货地址
     */
    private String serviceRouteOriginAddress;

    /**
     * 提货地Id
     */
    private String serviceRouteOriginId;

    /**
     * 客户详细地址
     */
    private String customerDetailAddress;

    /**
     * 对账单id
     */
    private String transStatementId;

    /**
     * 签收图片
     */
    private String images;

    private Integer transType;

    private List<String> imageList;

    /**
     * 是否结算
     */
    private Integer settle = 1;

    private String deliveryBillNumber;

    private String shipDocLineNo;

    private String deptId;

    private String salesId;

    private String salesNm;

    /**
     * 销售员 u9 code
     */
    private String salesCd;

    /**
     * 客户 u9 code
     */
    private String custCd;

    private String transDatetimeStr;

    private String deliveryDateStr;

    private String preDeliveryDateStr;

    private Date pickUpTime;
    /**
     * 要求提货日期
     */
    private String pickUpTimeStr;

    /**
     * 实际提货日期
     */
    private String startTimeStr;

    /**
     * 起运地大区(U9 Code)
     */
    private String orgBigAreaCd;

    /**
     * 客户地址所在大区(U9 Code)
     */
    private String destBigAreaCd;

    private String deptName;

    /**
     * 实际提货日期
     */
    private Date pickUpDate;

    private String pickUpDateStr;

    private PretVender pretVender;

    private PretCustomer pretCustomer;

    /**
     * 司机信息
     */
    private PretDriver pretDriver;

    /**
     * 异常明细
     */
    private List<PretTransExceptionItem> pretTransExceptionItemList;

    private PretServiceRouteOrigin pretServiceRouteOrigin;

    private List<PretTransOrder> pretTransOrderList;

    private List<PretTransFeeItem> pretTransFeeItemList;

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
    public PretDriver getPretDriver() {
        return pretDriver;
    }

    public void setPretDriver(PretDriver pretDriver) {
        this.pretDriver = pretDriver;
    }

    @Transient()
    public List<PretTransExceptionItem> getPretTransExceptionItemList() {
        return pretTransExceptionItemList;
    }

    public void setPretTransExceptionItemList(List<PretTransExceptionItem> pretTransExceptionItemList) {
        this.pretTransExceptionItemList = pretTransExceptionItemList;
    }

    @Transient()
    public PretServiceRouteOrigin getPretServiceRouteOrigin() {
        return pretServiceRouteOrigin;
    }

    public void setPretServiceRouteOrigin(PretServiceRouteOrigin pretServiceRouteOrigin) {
        this.pretServiceRouteOrigin = pretServiceRouteOrigin;
    }

    @Transient()
    public List<PretTransOrder> getPretTransOrderList() {
        return pretTransOrderList;
    }

    public void setPretTransOrderList(List<PretTransOrder> pretTransOrderList) {
        this.pretTransOrderList = pretTransOrderList;
    }

    @Transient()
    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    @Transient()
    public String getTransDatetimeStr() {
        return transDatetimeStr;
    }

    public void setTransDatetimeStr(String transDatetimeStr) {
        this.transDatetimeStr = transDatetimeStr;
    }

    @Transient()
    public String getDeliveryDateStr() {
        return deliveryDateStr;
    }

    public void setDeliveryDateStr(String deliveryDateStr) {
        this.deliveryDateStr = deliveryDateStr;
    }

    @Transient()
    public String getPreDeliveryDateStr() {
        return preDeliveryDateStr;
    }

    public void setPreDeliveryDateStr(String preDeliveryDateStr) {
        this.preDeliveryDateStr = preDeliveryDateStr;
    }

    @Transient()
    public List<PretTransFeeItem> getPretTransFeeItemList() {
        return pretTransFeeItemList;
    }

    public void setPretTransFeeItemList(List<PretTransFeeItem> pretTransFeeItemList) {
        this.pretTransFeeItemList = pretTransFeeItemList;
    }

    @Transient()
    public String getPickUpDateStr() {
        return pickUpDateStr;
    }

    public void setPickUpDateStr(String pickUpDateStr) {
        this.pickUpDateStr = pickUpDateStr;
    }

    @Transient()
    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }
}
