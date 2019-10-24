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
    private String id;
    /**
     * 线路名称
     */
    private String name;

    /**
     * 供应商id
     */
    private String venderId;

    private String serviceRouteItemStr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getServiceRouteItemStr() {
        return serviceRouteItemStr;
    }

    public void setServiceRouteItemStr(String serviceRouteItemStr) {
        this.serviceRouteItemStr = serviceRouteItemStr;
    }
}
