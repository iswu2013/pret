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
@Table(name = "pret_customer_address")
@Excel("客户地址")
@Data
public class PretCustomerAddress extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
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
    private String customerId;

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
     * 联系人
     */
    @ExcelField(value = "联系人")
    private String linkName;

    /**
     * 联系电话
     */
    @ExcelField(value = "联系电话")
    private String linkPhone;

    // setter and getter
}
