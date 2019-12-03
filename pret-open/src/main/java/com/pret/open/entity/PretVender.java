package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>Description: 物流供应商</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_vender")
@Excel("物流供应商")
@Data
public class PretVender extends VersionedAuditableIdEntity implements Serializable {

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
     * 编号
     */
    @ExcelField(value = "编号")
    private String code;

    /**
     * 名称
     */
    @ExcelField(value = "名称")
    private String name;

    /**
     * 联系人
     */
    @ExcelField(value = "联系人")
    private String linkName;

    /**
     * 联系号码
     */
    @ExcelField(value = "联系号码")
    private String linkPhone;

    /**
     * 所属用户id
     */
    private String userId;

    /**
     * 供应商类型
     */
    private Integer type;

    /**
     * 价格明细配置
     */
    @Column(length = 8255)
    private String pretQuotationItemStr;

    private BigDecimal unitPrice;

    private BigDecimal feight;

    private Float prescription;

    /**
     * 理货员，支持多个
     */
    private String tallyClerkId;

    /**
     * 理货员信息
     */
    private String tallyClerkStr;

    private List<PretServiceRouteOriginUser> serviceRouteOriginUserDataSource;

    // setter and getter

    @Transient()
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Transient()
    public BigDecimal getFeight() {
        return feight;
    }

    public void setFeight(BigDecimal feight) {
        this.feight = feight;
    }

    @Transient()
    public Float getPrescription() {
        return prescription;
    }

    public void setPrescription(Float prescription) {
        this.prescription = prescription;
    }

    @Transient()
    public String getTallyClerkStr() {
        return tallyClerkStr;
    }

    public void setTallyClerkStr(String tallyClerkStr) {
        this.tallyClerkStr = tallyClerkStr;
    }

    @Transient()
    public List<PretServiceRouteOriginUser> getServiceRouteOriginUserDataSource() {
        return serviceRouteOriginUserDataSource;
    }

    public void setServiceRouteOriginUserDataSource(List<PretServiceRouteOriginUser> serviceRouteOriginUserDataSource) {
        this.serviceRouteOriginUserDataSource = serviceRouteOriginUserDataSource;
    }
}
