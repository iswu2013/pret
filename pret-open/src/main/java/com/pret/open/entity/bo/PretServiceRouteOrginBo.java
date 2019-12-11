package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.PretVender;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretServiceRouteOrginBo {

    private static final long serialVersionUID = 1L;

    /**
     * 提货地址id
     */
    private String addressId;

    /**
     * 起运地名称
     */
    private String name;

    private String linkMan;

    private String linkPhone;

    /**
     * U9code
     */
    private String code;

    /**
     * 地址
     */
    private String detail;

    private String tallylerkIds;
}
