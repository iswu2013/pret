package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
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
@Table(name = "pret_service_route_item")
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
    private String serviceLineId;
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

    // setter and getter

    /**
     * <p>Discription:[服务线路id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceLineId() {
        return serviceLineId;
    }

    /**
     * <p>Discription:[服务线路id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceLineId(String serviceLineId) {
        this.serviceLineId = serviceLineId;
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
}
