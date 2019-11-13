package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 起运地</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_service_route_orgin")
@Excel("起运地")
@Data
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

    private String nowProvince;

    private String nowCity;

    private String nowArea;

    // setter and getter

    @Transient()
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Transient()
    public String getNowProvince() {
        return nowProvince;
    }

    public void setNowProvince(String nowProvince) {
        this.nowProvince = nowProvince;
    }

    @Transient()
    public String getNowCity() {
        return nowCity;
    }

    public void setNowCity(String nowCity) {
        this.nowCity = nowCity;
    }

    @Transient()
    public String getNowArea() {
        return nowArea;
    }

    public void setNowArea(String nowArea) {
        this.nowArea = nowArea;
    }
}
