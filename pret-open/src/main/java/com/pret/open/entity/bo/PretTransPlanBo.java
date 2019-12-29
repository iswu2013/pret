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
 * <p>Description: 运输计划</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Data
public class PretTransPlanBo {
    /**
     * 提货计划ids
     */
    private String pickUpIds;

    /**
     * 操作人
     */
    private String username;

    /**
     * mailno
     */
    private String mailno;

    // setter and getter
}
