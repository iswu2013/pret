package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.wuwenze.poi.annotation.Excel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "pret_member_auth")
@Excel("路由")
@Data
public class PretMemberAuth extends VersionedAuditableIdEntity implements Serializable {
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

    private Integer userType;

    private String name;

    private String mobile;

    private String openid;

    private String no;

    private String serviceRouteOriginId;

    private Integer status = ConstantEnum.EAuthStatus.待审核.getLabel();

    private String authUsername;

    private Long authDate;

    private String nickName;

    private String avatarUrl;

    private String deptId;
}