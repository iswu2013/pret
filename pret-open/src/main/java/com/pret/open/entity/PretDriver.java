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
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_driver")
@Excel("司机")
@Data
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
    @ExcelField(value = "司机姓名")
    private String name;

    /**
     * 司机电话
     */
    @ExcelField(value = "司机电话")
    private String phone;

    /**
     * 车牌号
     */
    @ExcelField(value = "车牌号")
    private String carNumber;

    /**
     * 车型
     */
    @ExcelField(value = "车型")
    private String vehicleType;

    /**
     * 车长
     */
    @ExcelField(value = "车长")
    private String vehicleLength;

    /**
     * 司机openid
     */
    @ExcelField(value = "联系电话")
    private String openid;

    // setter and getter
}
