package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretServiceRouteItemBo {
    /**
     * 起运地id
     */
    private String serviceRouteOrginId;
    /**
     * 地址id
     */
    private String addressId;
    /**
     * 时效(天)
     */
    private Integer prescription;

    public String getServiceRouteOrginId() {
        return serviceRouteOrginId;
    }

    public void setServiceRouteOrginId(String serviceRouteOrginId) {
        this.serviceRouteOrginId = serviceRouteOrginId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Integer getPrescription() {
        return prescription;
    }

    public void setPrescription(Integer prescription) {
        this.prescription = prescription;
    }
}
