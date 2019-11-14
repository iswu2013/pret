package com.pret.open.entity.user;

import com.pret.common.VersionedAuditableIdEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>Description: [tmodel]</p>
 * Created on 2019年10月19日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "t_user")
@Data
public class User extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator = "idGenerator")
    @Override
    public String getId() {
        return id;
    }

    public static final String DEFAULT_PASSWORD = "admin1";

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 部门ID
     */
    private String deptId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 状态 0锁定 1有效
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 最近访问时间
     */
    private Date lastLoginTime;
    /**
     * 性别 0男 1女 2保密
     */
    private String ssex;
    /**
     * 描述
     */
    private String description;
    /**
     * 用户头像
     */
    private String avatar;

    /**
     * openid
     */
    private String openid;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 父用户
     */
    private String parentId;

    /**
     * 供应商id
     */
    private String venderId;

    // setter and getter
}
