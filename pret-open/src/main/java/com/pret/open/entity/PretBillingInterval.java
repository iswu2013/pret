package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_billing_interval")
@Excel("计费区间")
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
     * 区间明细
     */
    private List<PretBillingIntervalItem> pretBillingIntervalItemList;

    // setter and getter

    /**
     * <p>Discription:[计费区间名称]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Discription:[计费区间名称]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setName(String name) {
        this.name = name;
    }

    @Transient()
    public List<PretBillingIntervalItem> getPretBillingIntervalItemList() {
        return pretBillingIntervalItemList;
    }

    public void setPretBillingIntervalItemList(List<PretBillingIntervalItem> pretBillingIntervalItemList) {
        this.pretBillingIntervalItemList = pretBillingIntervalItemList;
    }
}
