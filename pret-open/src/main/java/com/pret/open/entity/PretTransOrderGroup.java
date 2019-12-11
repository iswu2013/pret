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
import java.util.Date;
import java.util.List;

/**
 * <p>Description: 运输单</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_order_group")
@Excel("运输单")
@Data
public class PretTransOrderGroup extends VersionedAuditableIdEntity implements Serializable {

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
     * 0:非返程；1：返程配送单
     */
    private Integer type = ConstantEnum.EPretTransOrderType.非返程.getLabel();

    /**
     * 订单号
     */
    @ExcelField(value = "订单号")
    private String sourceCode;

    /**
     * 销售员 u9 code
     */
    private String salesCd;

    /**
     * 业务员名称
     */
    private String salesNm;

    /**
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;

    /**
     * 运输方式
     */
    @ExcelField(value = "运输方式")
    private String transModeCd;

    /**
     * 运输方式名称
     */
    private String transModeNm;

    /**
     * 提货日期
     */
    @ExcelField(value = "提货日期", writeConverter = TimeConverter.class)
    private Date takeDeliveryDate;

    /**
     * 送达日期
     */
    @ExcelField(value = "送达日期", writeConverter = TimeConverter.class)
    private Date deliveryDate;

    /**
     * 送货单号
     */
    @ExcelField(value = "送货单号")
    private String deliveryBillNumber;

    /**
     * 提货地Id
     */
    private String serviceRouteOriginId;

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
     * 送达客户id
     */
    @ExcelField(value = "送达客户id")
    private String customerId;

    /**
     * 客户名称
     */
    @ExcelField(value = "客户名称")
    private String customerName;

    /**
     * 客户地址
     */
    @ExcelField(value = "客户地址")
    private String customerAddress;

    /**
     * 客户详细地址
     */
    @ExcelField(value = "客户详细地址")
    private String customerDetailAddress;

    /**
     * 客户地址
     */
    private String addressId;

    /**
     * 客户联系人
     */
    @ExcelField(value = "客户联系人")
    private String customerLinkName;

    /**
     * 客户联系人电话
     */
    @ExcelField(value = "客户联系人电话")
    private String customerLinkPhone;

    /**
     * 状态
     */
    @ExcelField(value = "状态", writeConverterExp = "1=待分配,2=待提货,3=计划提货,4=完成提货,5=起运,6=签收")
    private int status = ConstantEnum.ETransOrderStatus.待分配.getLabel();

    /**
     * 提货工厂code
     */
    @ExcelField(value = "提货工厂code")
    private String pickupFactoryCd;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 0重货1泡货
     */
    private Integer goodsType;

    /**
     * 空转单标志0:非空转单  1:空转单
     */
    private Integer preOrderFlag = 0;

    /**
     * 销售备注
     */
    private String remark;

    /**
     * 储位
     */
    private String storageNumber;

    /**
     * 起运地大区(U9 Code)
     */
    private String orgBigAreaCd;

    /**
     * 客户地址所在大区(U9 Code)
     */
    private String destBigAreaCd;

    private String deptId;

    private String ownFactoryCd;

    /**
     * 总体积.(加总明细档中的CBM)
     */
    private Float totalCbm;

    /**
     * 总件数.(加总明细档中的goodsNum)
     */
    private Integer totalPkg;

    /**
     * 供应商
     */
    private PretVender pretVender;

    /**
     * 客户
     */
    private PretCustomer pretCustomer;

    private PretServiceRouteOrigin pretServiceRouteOrigin;

    private List<PretTransOrder> pretTransOrderList;

    private Float totalGw;

    // setter and getter

    @Transient()
    public PretCustomer getPretCustomer() {
        return pretCustomer;
    }

    public void setPretCustomer(PretCustomer pretCustomer) {
        this.pretCustomer = pretCustomer;
    }

    @Transient()
    public PretServiceRouteOrigin getPretServiceRouteOrigin() {
        return pretServiceRouteOrigin;
    }

    public void setPretServiceRouteOrigin(PretServiceRouteOrigin pretServiceRouteOrigin) {
        this.pretServiceRouteOrigin = pretServiceRouteOrigin;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public List<PretTransOrder> getPretTransOrderList() {
        return pretTransOrderList;
    }

    public void setPretTransOrderList(List<PretTransOrder> pretTransOrderList) {
        this.pretTransOrderList = pretTransOrderList;
    }

    @Transient()
    public Float getTotalGw() {
        return totalGw;
    }

    public void setTotalGw(Float totalGw) {
        this.totalGw = totalGw;
    }
}
