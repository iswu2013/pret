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
@Table(name = "pret_vender")
public class PretVender extends VersionedAuditableIdEntity implements Serializable {

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
     * 编号
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 联系人
     */
    private String linkName;
    /**
     * 联系号码
     */
    private String linkPhone;

    /**
     * 所属用户id
     */
    private Long userId;

    // setter and getter

    /**
     * <p>Discription:[编号]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCode() {
        return code;
    }

    /**
     * <p>Discription:[编号]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <p>Discription:[名称]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[名称]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Discription:[联系人]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * <p>Discription:[联系人]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    /**
     * <p>Discription:[联系号码]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * <p>Discription:[联系号码]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
