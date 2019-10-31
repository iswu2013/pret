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
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;
    /**
     * 服务线路id
     */
    @ExcelField(value = "服务线路id")
    private String serviceRouteId;
    /**
     * 提货地址id
     */
    @ExcelField(value = "提货地址id")
    private String pickUpAddressId;

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

    @Transient()
    private PretVender pretVender;

    // setter and getter

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
     * <p>Discription:[服务线路id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteId() {
        return serviceRouteId;
    }

    /**
     * <p>Discription:[服务线路id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    /**
     * <p>Discription:[提货地址id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPickUpAddressId() {
        return pickUpAddressId;
    }

    /**
     * <p>Discription:[提货地址id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPickUpAddressId(String pickUpAddressId) {
        this.pickUpAddressId = pickUpAddressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
