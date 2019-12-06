package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: 运输异常</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_exception_handle_record")
@Excel("异常处理记录")
@Data
public class PretTransExceptionHandleRecord extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    /**
     * 异常id
     */
    private String exceptionId;

    /**
     * 描述
     */
    private String description;

    /**
     * 处理图片
     */
    private String images;

    /**
     * 处理人
     */
    private String handleUserId;

    /**
     * 处理人名称
     */
    private String handleUserName;

    /**
     * 角色类型1货主2物流
     */
    private Integer type;

    private List<String> imagesList = new ArrayList<>();

    @Transient()
    public List<String> getImagesList() {
        return imagesList;
    }

    public void setImagesList(List<String> imagesList) {
        this.imagesList = imagesList;
    }
}
