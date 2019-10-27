package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "pret_trans_order")
public class PretTransOrder extends VersionedAuditableIdEntity implements Serializable {

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
     * 订单号
     */
    private String orderNo;
    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 运输方式
     */
    private String transMode;
    /**
     * 提货日期
     */
    private Date takeDeliveryDate;
    /**
     * 送达日期
     */
    private Date deliveryDate;
    /**
     * 送货单号
     */
    private String deliveryBillNumber;
    /**
     * 起运地
     */
    private String serviceRouteOrginId;
    /**
     * 送达客户id
     */
    private String customerId;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 客户地址
     */
    private String customerAddress;
    /**
     * 客户联系人
     */
    private String customerLinkName;
    /**
     * 客户联系人电话
     */
    private String customerLinkPhone;

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
     * 对账单id
     */
    private String transStatementId;
    /**
     * 商品数量
     */
    private Integer gw;
    /**
     * 单位(1吨，2公斤)
     */
    private int unit;

    /**
     * 立方体积
     */
    private float cbm;

    /**
     * 货物件数
     */
    private int goodsNum;

    /**
     * 状态
     */
    private int status;

    /**
     * 提货工厂code
     */
    private String pickupFactoryCd;

    @Transient()
    private PretVender pretVender;

    @Transient()
    private PretGoods pretGoods;

    @Transient()
    private PretCustomer pretCustomer;

    // setter and getter

    /**
     * <p>Discription:[订单号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * <p>Discription:[订单号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
     * <p>Discription:[运输方式]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransMode() {
        return transMode;
    }

    /**
     * <p>Discription:[运输方式]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    /**
     * <p>Discription:[提货日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getTakeDeliveryDate() {
        return takeDeliveryDate;
    }

    /**
     * <p>Discription:[提货日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTakeDeliveryDate(java.util.Date takeDeliveryDate) {
        this.takeDeliveryDate = takeDeliveryDate;
    }

    /**
     * <p>Discription:[送达日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * <p>Discription:[送达日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDeliveryDate(java.util.Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * <p>Discription:[送货单号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDeliveryBillNumber() {
        return deliveryBillNumber;
    }

    /**
     * <p>Discription:[送货单号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDeliveryBillNumber(String deliveryBillNumber) {
        this.deliveryBillNumber = deliveryBillNumber;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteOrginId() {
        return serviceRouteOrginId;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteOrginId(String serviceRouteOrginId) {
        this.serviceRouteOrginId = serviceRouteOrginId;
    }

    /**
     * <p>Discription:[送达客户id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * <p>Discription:[送达客户id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * <p>Discription:[客户名称]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * <p>Discription:[客户名称]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * <p>Discription:[客户地址]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * <p>Discription:[客户地址]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * <p>Discription:[客户联系人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerLinkName() {
        return customerLinkName;
    }

    /**
     * <p>Discription:[客户联系人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerLinkName(String customerLinkName) {
        this.customerLinkName = customerLinkName;
    }

    /**
     * <p>Discription:[客户联系人电话]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerLinkPhone() {
        return customerLinkPhone;
    }

    /**
     * <p>Discription:[客户联系人电话]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerLinkPhone(String customerLinkPhone) {
        this.customerLinkPhone = customerLinkPhone;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getPickUpPlanId() {
        return pickUpPlanId;
    }

    public void setPickUpPlanId(String pickUpPlanId) {
        this.pickUpPlanId = pickUpPlanId;
    }

    public String getTransPlanId() {
        return transPlanId;
    }

    public void setTransPlanId(String transPlanId) {
        this.transPlanId = transPlanId;
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

    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    public PretGoods getPretGoods() {
        return pretGoods;
    }

    public void setPretGoods(PretGoods pretGoods) {
        this.pretGoods = pretGoods;
    }

    public PretCustomer getPretCustomer() {
        return pretCustomer;
    }

    public void setPretCustomer(PretCustomer pretCustomer) {
        this.pretCustomer = pretCustomer;
    }

    public String getPickupFactoryCd() {
        return pickupFactoryCd;
    }

    public void setPickupFactoryCd(String pickupFactoryCd) {
        this.pickupFactoryCd = pickupFactoryCd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTransStatementId() {
        return transStatementId;
    }

    public void setTransStatementId(String transStatementId) {
        this.transStatementId = transStatementId;
    }
}
