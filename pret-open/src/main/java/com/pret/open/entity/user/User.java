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
@Table(name = "t_user")
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
    private Long deptId;
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
    private java.util.Date createTime;
    /**
     * 修改时间
     */
    private java.util.Date modifyTime;
    /**
     * 最近访问时间
     */
    private java.util.Date lastLoginTime;
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

    // setter and getter

    /**
     * <p>Discription:[用户名]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getUsername() {
        return username;
    }

    /**
     * <p>Discription:[用户名]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * <p>Discription:[密码]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getPassword() {
        return password;
    }

    /**
     * <p>Discription:[密码]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <p>Discription:[部门ID]</p>
     * Created on 2019年10月19日
     *
     * @return Long
     * @author:wujinsong
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * <p>Discription:[部门ID]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * <p>Discription:[邮箱]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getEmail() {
        return email;
    }

    /**
     * <p>Discription:[邮箱]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <p>Discription:[联系电话]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * <p>Discription:[联系电话]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * <p>Discription:[状态 0锁定 1有效]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getStatus() {
        return status;
    }

    /**
     * <p>Discription:[状态 0锁定 1有效]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * <p>Discription:[最近访问时间]</p>
     * Created on 2019年10月19日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * <p>Discription:[最近访问时间]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setLastLoginTime(java.util.Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * <p>Discription:[性别 0男 1女 2保密]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getSsex() {
        return ssex;
    }

    /**
     * <p>Discription:[性别 0男 1女 2保密]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDescription() {
        return description;
    }

    /**
     * <p>Discription:[描述]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <p>Discription:[用户头像]</p>
     * Created on 2019年10月19日
     *
     * @return String
     * @author:wujinsong
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * <p>Discription:[用户头像]</p>
     * Created on 2019年10月19日
     *
     * @author:wujinsong
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}