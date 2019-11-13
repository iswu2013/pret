package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 计费区间</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_billing_interval")
@Excel("计费区间")
@Data
public class PretBillingInterval extends VersionedAuditableIdEntity implements Serializable {

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

    /**
     * 计费区间名称
     */
    @ExcelField(value = "名称")
    private String name;

    /**
     * 创建人
     */
    @ExcelField(value = "创建人")
    private String username;

    /**
     * 区间明细
     */
    private List<PretBillingIntervalItem> pretBillingIntervalItemList;

    // setter and getter

    @Transient()
    public List<PretBillingIntervalItem> getPretBillingIntervalItemList() {
        return pretBillingIntervalItemList;
    }

    public void setPretBillingIntervalItemList(List<PretBillingIntervalItem> pretBillingIntervalItemList) {
        this.pretBillingIntervalItemList = pretBillingIntervalItemList;
    }
}
