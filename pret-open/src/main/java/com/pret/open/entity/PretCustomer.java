package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: 客户</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_customer")
@Excel("客户")
@Data
public class PretCustomer extends VersionedAuditableIdEntity implements Serializable {

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
     * 客户名称
     */
    @ExcelField(value = "客户名称")
    private String name;

    /**
     * 客户联系人
     */
    @ExcelField(value = "客户联系人")
    private String linkName;
    /**
     * 客户联系人电话
     */
    @ExcelField(value = "客户联系人电话")
    private String linkPhone;

    @ExcelField(value = "openid")
    private String openid;

    /**
     * 客户编码
     */
    private String code;

    private Integer status;

    private String nickName;

    private String avatar;



    // setter and getter
}
