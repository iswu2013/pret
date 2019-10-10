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
@Table(name = "pret_address")
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

    // setter and getter

    /**
     * <p>Discription:[地址名称]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[地址名称]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Discription:[地址值]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getValue() {
        return value;
    }

    /**
     * <p>Discription:[地址值]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * <p>Discription:[父id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * <p>Discription:[父id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * <p>Discription:[0省1市2区县]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * <p>Discription:[0省1市2区县]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setLevels(Integer levels) {
        this.levels = levels;
    }
}
