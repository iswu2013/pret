package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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
public class PretTransExceptionBo {
    /**
     * 运输计划id
     */
    private String transPlanId;

    /**
     * 处理方式
     */
    private Integer handleStyle;

    /**
     * 责任方0物流1货主2客户
     */
    private Integer responsibleParty;

    /**
     * 异常明细
     */
    private String transExceptionStr;

    // setter and getter
}
