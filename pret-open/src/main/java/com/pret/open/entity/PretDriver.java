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
@Table(name = "pret_driver")
public class PretDriver extends VersionedAuditableIdEntity implements Serializable {

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
     * 司机姓名
     */
    private String name;
    /**
     * 司机电话
     */
    private String phone;
    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 车型
     */
    private String vehicleType;

    /**
     * 车长
     */
    private String vehicleLength;

    /**
     * 司机openid
     */
    private String openid;

    // setter and getter

    /**
     * <p>Discription:[司机姓名]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[司机姓名]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Discription:[司机电话]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <p>Discription:[司机电话]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * <p>Discription:[车牌号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * <p>Discription:[车牌号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        this.vehicleLength = vehicleLength;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
