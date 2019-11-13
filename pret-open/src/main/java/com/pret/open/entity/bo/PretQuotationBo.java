package com.pret.open.entity.bo;

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
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretQuotationBo {

    private String id;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 线路明细id
     */
    private String serviceRouteItemId;

    /**
     * 报价开始日期
     */
    private String periodFromStr;
    /**
     * 报价截止日期
     */
    private String periodToStr;

    /**
     * 报价明细
     */
    private String pretQuotationItemStr;

    /**
     * 计费区间
     */
    private String billingIntervalId;

    /**
     * 创建用户
     */
    private String username;
}
