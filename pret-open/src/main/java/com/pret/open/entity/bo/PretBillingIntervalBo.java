package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.PretVender;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 计费区间明细</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretBillingIntervalBo {
    private String id;

    /**
     * 计费区间名称
     */
    private String name;
    /**
     * 线路id
     */
    private String serviceRouteId;

    private String username;

    private String billingIntervalItemStr;

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

    public String getServiceRouteId() {
        return serviceRouteId;
    }

    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    public String getBillingIntervalItemStr() {
        return billingIntervalItemStr;
    }

    public void setBillingIntervalItemStr(String billingIntervalItemStr) {
        this.billingIntervalItemStr = billingIntervalItemStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
