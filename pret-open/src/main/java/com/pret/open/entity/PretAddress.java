package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 地址</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_addresss")
@Excel("地址")
@Data
public class PretAddress extends VersionedAuditableIdEntity implements Serializable {

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

    private String ids;

    /**
     * 地址名称
     */
    private String name;

    /**
     * 地址值
     */
    private String value;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 父名称
     */
    private String parentName;

    /**
     * 0省1市2区县
     */
    private Integer levels;

    /**
     * 时效
     */
    private Integer prescription;

    /**
     * 是否是add的(0不是1是)，针对全省，全市的情况
     */
    private Integer adds;

    private List<PretAddress> children;

    // setter and getter

    @Transient()
    public List<PretAddress> getChildren() {
        return children;
    }

    public void setChildren(List<PretAddress> children) {
        this.children = children;
    }
}
