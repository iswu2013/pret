package com.pret.common;

/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 统一定义顶层Entity实体审计 基类
 * <p>
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * Oracle需要每个Entity独立定义id的SEQUCENCE时，不继承于本类而改为实现一个Idable的接口。
 */
// JPA 基类的标识
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class AuditableEntity implements Serializable {
    private static final long serialVersionUID = 141481953116476081L;
    protected String id;

    private Long version;// 版本

    private long createTimeLong;// 创建时间

    private String createTimeStr;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date lastModifiedDate;// 最后修改时间

    /**
     * 状态
     */
    private int s = ConstantEnum.S.N.getLabel();

    @Column(nullable = true, columnDefinition = "bigint(20) DEFAULT 0")
    public long getCreateTimeLong() {
        return createTimeLong;
    }

    public void setCreateTimeLong(long createTimeLong) {
        this.createTimeLong = createTimeLong;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Auditable#getLastModifiedDate()
     */
    @JsonIgnore()
    public Date getLastModifiedDate() {

        return lastModifiedDate;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.data.domain.Auditable#setLastModifiedDate(org.joda
     * .time.DateTime)
     */
    public void setLastModifiedDate(final Date lastModifiedDate) {

        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Sets the id of the entity.
     *
     * @param id the id to set
     */
    public void setId(final String id) {

        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.data.domain.Persistable#isNew()
     */
    @Transient
    @JsonIgnore()
    public boolean isNew() {

        return null == id;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return String.format("Entity of type %s with id: %s", this.getClass().getName(), id);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        VersionedAuditableIdEntity that = (VersionedAuditableIdEntity) obj;

        return null == id ? false : id.equals(that.getId());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int hashCode = 17;

        hashCode += null == id ? 0 : id.hashCode() * 31;

        return hashCode;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    @Version
    @JsonIgnore()
    @Column(columnDefinition = "bigint(20) DEFAULT 0")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @PreUpdate
    public void preUpdate() {
        this.lastModifiedDate = new Date();
    }

    @PrePersist
    public void prePersist() {
        this.lastModifiedDate = new Date();
        Date now = new Date();
        if (this.createTimeLong > 0) {
            now = DateUtils.addMinutes(now, -30);
        }
        this.createTimeLong = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.createTimeStr = format.format(now);
    }
}
