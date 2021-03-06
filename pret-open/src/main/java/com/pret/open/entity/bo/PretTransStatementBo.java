package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransStatementBo {
    /**
     * 对账单id
     */
    private String id;
    /**
     * 运输费用id
     */
    private String ids;

    /**
     * 收款人
     */
    private String billToId;
    /**
     * 付款人
     */
    private String payById;
    /**
     * 对账日期
     */
    private java.util.Date checkDate;
    /**
     * 对账开始日期
     */
    private String periodFromStr;
    /**
     * 对账截止日期
     */
    private String periodToStr;
    /**
     * 费用总额
     */
    private BigDecimal totalAmount;
    /**
     *
     */
    private BigDecimal penIndAmount;
    /**
     *
     */
    private Long realAmount;

    private String currencyId;

    private String username;

    // setter and getter

}
