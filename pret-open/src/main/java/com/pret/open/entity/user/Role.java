package com.pret.open.entity.user;

import com.pret.common.VersionedAuditableIdEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: [tmodel]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "t_role")
public class Role extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String remark;
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    // setter and getter


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * <p>Discription:[角色名称]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * <p>Discription:[角色名称]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * <p>Discription:[角色描述]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>Discription:[角色描述]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>Discription:[创建时间]</p>
     * Created on 2019年10月19日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
     * <p>Discription:[创建时间]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <p>Discription:[修改时间]</p>
     * Created on 2019年10月19日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getModifyTime() {
        return modifyTime;
    }

    /**
     * <p>Discription:[修改时间]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
