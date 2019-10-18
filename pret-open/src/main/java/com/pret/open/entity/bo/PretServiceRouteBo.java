package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.PretBillingInterval;
import com.pret.open.entity.PretServiceRouteOrgin;
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
public class PretServiceRouteBo {
    /**
     * 线路名称
     */
    private String name;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 起运地(可多条)
     */
    private String seviceRouteOrginId;

    private String serviceRouteItemStr;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getSeviceRouteOrginId() {
        return seviceRouteOrginId;
    }

    public void setSeviceRouteOrginId(String seviceRouteOrginId) {
        this.seviceRouteOrginId = seviceRouteOrginId;
    }

    public String getServiceRouteItemStr() {
        return serviceRouteItemStr;
    }

    public void setServiceRouteItemStr(String serviceRouteItemStr) {
        this.serviceRouteItemStr = serviceRouteItemStr;
    }
}
