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
 * <p>Description: 运输轨迹</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_trajectory")
@Excel("运输轨迹")
@Data
public class PretTransTrajectory extends VersionedAuditableIdEntity implements Serializable {

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
     * 运输计划id
     */
    @ExcelField(value = "运输计划id")
    private String transPlanId;

    /**
     * 司机id
     */
    @ExcelField(value = "司机id")
    private String driverId;

    /**
     * 地址id
     */
    @ExcelField(value = "地址id")
    private String addressId;

    /**
     * 详细地址
     */
    @ExcelField(value = "详细地址")
    private String detail;

    /**
     * 备注
     */
    @ExcelField(value = "备注")
    private String remark;

    /**
     * 完整地址
     */
    private String address;

    // setter and getter

    @Transient()
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
