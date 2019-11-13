package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: 服务线路项</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_service_route_item")
@Excel("服务线路项")
@Data
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
    @ExcelField(value = "服务线路id")
    private String serviceRouteId;

    /**
     * 物流供应商
     */
    @ExcelField(value = "物流供应商")
    private String venderId;

    /**
     * 起运地id
     */
    @ExcelField(value = "起运地id")
    private String serviceRouteOriginId;

    /**
     * 起运地地址id
     */
    private String orginAddressId;

    /**
     * u9code
     */
    @ExcelField(value = "u9code")
    private String code;

    /**
     * 目的地址
     */
    @ExcelField(value = "目的地址")
    private String addressId;

    /**
     * 时效(天)
     */
    @ExcelField(value = "时效")
    private Integer prescription;

    /**
     * 里程
     */
    @ExcelField(value = "里程")
    private Float mileage;

    /**
     * 自动分配下限
     */
    @ExcelField(value = "自动分配下限")
    private Float lowerLimit;

    /**
     * 起始地名称
     */
    @ExcelField(value = "起始地名称")
    private String startEndName;

    /**
     * 供应商
     */
    private PretVender pretVender;

    // setter and getter

    @Transient()
    public String getStartEndName() {
        return startEndName;
    }

    public void setStartEndName(String startEndName) {
        this.startEndName = startEndName;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }
}
