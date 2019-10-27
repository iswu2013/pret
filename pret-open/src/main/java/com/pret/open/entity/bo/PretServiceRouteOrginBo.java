package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.PretVender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretServiceRouteOrginBo {

    private static final long serialVersionUID = 1L;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 服务线路id
     */
    private String serviceRouteId;
    /**
     * 提货地址id
     */
    private String pickUpAddressId;

    /**
     * 起运地名称
     */
    private String name;

    /**
     * U9code
     */
    private String code;

    /**
     * 地址
     */
    private String addressStr;

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getServiceRouteId() {
        return serviceRouteId;
    }

    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    public String getPickUpAddressId() {
        return pickUpAddressId;
    }

    public void setPickUpAddressId(String pickUpAddressId) {
        this.pickUpAddressId = pickUpAddressId;
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

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }
}
