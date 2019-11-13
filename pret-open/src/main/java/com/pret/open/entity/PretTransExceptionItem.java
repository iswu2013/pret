package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: 运输异常明细</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_exception_item")
@Excel("运输异常明细")
@Data
public class PretTransExceptionItem extends VersionedAuditableIdEntity implements Serializable {

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
     * 异常id
     */
    @ExcelField(value = "异常id")
    private String transExceptionId;

    /**
     * 运输计划id
     */
    private String transPlanId;

    /**
     * 运输任务单明细id
     */
    private String transOrderId;

    /**
     * 图片id
     */
    private String picIds;

    /**
     * 异常数量
     */
    private Integer count;

    /**
     * 处理人
     */
    private String handleBy;

    // setter and getter
}
