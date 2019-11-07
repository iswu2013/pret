package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "pret_service_route_orgin")
@Excel("起运地")
public class PretServiceRouteOrgin extends VersionedAuditableIdEntity implements Serializable {

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
     * 提货地址id
     */
    @ExcelField(value = "提货地址id")
    private String addressId;

    /**
     * 起运地名称
     */
    @ExcelField(value = "起运地名称")
    private String name;

    /**
     * U9code
     */
    @ExcelField(value = "U9code")
    private String code;

    @ExcelField(value = "详细地址")
    private String detail;

    /**
     * 完整地址
     */
    private String fullAddress;

    // setter and getter


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Transient()
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
