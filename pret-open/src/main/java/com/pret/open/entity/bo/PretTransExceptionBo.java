package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class PretTransExceptionBo {
    private String id;


    /**
     * 责任方0物流1客户2工厂
     */
    @ExcelField(value = "责任方", writeConverterExp = "0=物流,1=客户,2=工厂")
    private Integer responsibleParty;


    /**
     * 是否运回0无1是2否
     */
    private Integer isReturnStatus = 0;

    /**
     * 是否结退回运费0无1是2否
     */
    private Integer returnFeeStatus;

    /**
     * 退回地址
     */
    private String returnAddress;

    /**
     * 返回至1提货工厂2其他地址
     */
    private String returnType;

    /**
     * 联系人
     */
    private String linkName;

    /**
     * 联系电话
     */
    private String linkPhone;

    /**
     * 赔偿金额
     */
    private BigDecimal compensation;

    /**
     * 退回地址
     */
    private String addressId;

    /**
     * 退回地址详情
     */
    private String addressDetail;

    private String handleUserName;

    private String handleUserId;


    // setter and getter
}
