package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.PretBillingIntervalItem;
import com.pret.open.entity.PretServiceRoute;
import com.pret.open.entity.PretVender;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 计费区间明细</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretBillingIntervalBo {
    private String id;

    /**
     * 计费区间名称
     */
    private String name;
    /**
     * 线路id
     */
    private String serviceRouteId;

    private String username;

    private String billingIntervalItemStr;
}
