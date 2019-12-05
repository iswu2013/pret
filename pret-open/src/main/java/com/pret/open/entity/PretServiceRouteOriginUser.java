package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.user.User;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 工厂员工</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_service_route_origin_user")
@Excel("费用类型")
@Data
public class PretServiceRouteOriginUser extends VersionedAuditableIdEntity implements Serializable {

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
     * 工厂id
     */
    private String serviceRouteOriginId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户类别
     */
    private String userType;

    /**
     * 供应商id
     */
    private String venderId;

    private User user;

    private PretVender pretVender;

    private PretServiceRouteOrigin pretServiceRouteOrigin;

    @Transient()
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretServiceRouteOrigin getPretServiceRouteOrigin() {
        return pretServiceRouteOrigin;
    }

    public void setPretServiceRouteOrigin(PretServiceRouteOrigin pretServiceRouteOrigin) {
        this.pretServiceRouteOrigin = pretServiceRouteOrigin;
    }
}
