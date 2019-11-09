package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "pret_service_route_item")
@Excel("服务线路项")
public class PretServiceRouteItem extends VersionedAuditableIdEntity implements Serializable {

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
     * 服务线路id
     */
    @ExcelField(value = "服务线路id")
    private String serviceRouteId;
    /**
     * 起运地id
     */
    @ExcelField(value = "起运地id")
    private String serviceRouteOrginId;

    /**
     * u9code
     */
    private String code;

    /**
     * 地址id
     */
    @ExcelField(value = "地址id")
    private String addressId;
    /**
     * 时效(天)
     */
    @ExcelField(value = "时效")
    private Integer prescription;

    /**
     * 物流供应商
     */
    @ExcelField(value = "物流供应商")
    private String venderId;

    /**
     * 起始地名称
     */
    @ExcelField(value = "起始地名称")
    private String startEndName;

    /**
     * 供应商
     */
    private PretVender pretVender;

    /**
     * 里程
     */
    private Float mileage;

    /**
     * 自动分配下限
     */
    private Float lowerLimit;

    // setter and getter


    public String getServiceRouteId() {
        return serviceRouteId;
    }

    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteOrginId() {
        return serviceRouteOrginId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteOrginId(String serviceRouteOrginId) {
        this.serviceRouteOrginId = serviceRouteOrginId;
    }

    /**
     * <p>Discription:[地址id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * <p>Discription:[地址id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <p>Discription:[时效(天)]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getPrescription() {
        return prescription;
    }

    /**
     * <p>Discription:[时效(天)]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPrescription(Integer prescription) {
        this.prescription = prescription;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    @Transient()
    public String getStartEndName() {
        return startEndName;
    }

    public void setStartEndName(String startEndName) {
        this.startEndName = startEndName;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    public Float getMileage() {
        return mileage;
    }

    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    public Float getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Float lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
}
