package com.pret.api.info;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo extends BaseInfo {
    private String id;

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
    private Integer status;
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
     * 是否已经绑定0否1是
     */
    private Integer binding;

    /**
     * 父用户
     */
    private String parentId;

    /**
     * 供应商id
     */
    private String venderId;

    /**
     * token
     */
    private String token;

    private String sessionKey;
}
