package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "pret_billing_interval")
public class PretBillingInterval extends VersionedAuditableIdEntity implements Serializable {

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
     * 计费区间名称
     */
    private String name;
    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 线路id
     */
    private String serviceRouteId;

    @Transient()
    private PretVender pretVender;

    @Transient()
    private PretServiceRoute pretServiceRoute;

    /**
     * 区间明细
     */
    private List<PretBillingIntervalItem> pretBillingIntervalItemList;

    // setter and getter

    /**
     * <p>Discription:[计费区间名称]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[计费区间名称]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setName(String name) {
        this.name = name;
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
     * <p>Discription:[线路id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteId() {
        return serviceRouteId;
    }

    /**
     * <p>Discription:[线路id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    public PretServiceRoute getPretServiceRoute() {
        return pretServiceRoute;
    }

    public void setPretServiceRoute(PretServiceRoute pretServiceRoute) {
        this.pretServiceRoute = pretServiceRoute;
    }

    public List<PretBillingIntervalItem> getPretBillingIntervalItemList() {
        return pretBillingIntervalItemList;
    }

    public void setPretBillingIntervalItemList(List<PretBillingIntervalItem> pretBillingIntervalItemList) {
        this.pretBillingIntervalItemList = pretBillingIntervalItemList;
    }
}
