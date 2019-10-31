package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "pret_trans_fee_item")
@Excel("运输费用项")
public class PretTransFeeItem extends VersionedAuditableIdEntity implements Serializable {

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
     * 供应商id
     */
    @ExcelField(value = "总金额")
    private String venderId;
    /**
     * 运输单费用id
     */
    @ExcelField(value = "总金额")
    private String transFeeId;
    /**
     * 1运费2罚款3赔款
     */
    private Integer type;
    /**
     * 运输计划id
     */
    @ExcelField(value = "总金额")
    private String transPlanId;
    /**
     * 计费数量
     */
    @ExcelField(value = "总金额")
    private Integer quotationCount;
    /**
     * 单价
     */
    @ExcelField(value = "总金额")
    private java.math.BigDecimal unitPrice;
    /**
     * 金额
     */
    @ExcelField(value = "总金额")
    private BigDecimal quotation;
    /**
     * 备注
     */
    private String remark;
    /**
     *
     */
    private String createBy;

    // setter and getter

    /**
     * <p>Discription:[供应商id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getVenderId() {
        return venderId;
    }

    /**
     * <p>Discription:[供应商id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    /**
     * <p>Discription:[运输单费用id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransFeeId() {
        return transFeeId;
    }

    /**
     * <p>Discription:[运输单费用id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransFeeId(String transFeeId) {
        this.transFeeId = transFeeId;
    }

    /**
     * <p>Discription:[1运费2罚款3赔款]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getType() {
        return type;
    }

    /**
     * <p>Discription:[1运费2罚款3赔款]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * <p>Discription:[运输计划id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getTransPlanId() {
        return transPlanId;
    }

    /**
     * <p>Discription:[运输计划id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransPlanId(String transPlanId) {
        this.transPlanId = transPlanId;
    }

    /**
     * <p>Discription:[计费数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getQuotationCount() {
        return quotationCount;
    }

    /**
     * <p>Discription:[计费数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotationCount(Integer quotationCount) {
        this.quotationCount = quotationCount;
    }

    /**
     * <p>Discription:[单价]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * <p>Discription:[单价]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setUnitPrice(java.math.BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * <p>Discription:[金额]</p>
     * Created on 2019年09月15日
     *
     * @return java.math.BigDecimal
     * @author:wujinsong
     */
    public BigDecimal getQuotation() {
        return quotation;
    }

    /**
     * <p>Discription:[金额]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setQuotation(BigDecimal quotation) {
        this.quotation = quotation;
    }

    /**
     * <p>Discription:[备注]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getRemark() {
        return remark;
    }

    /**
     * <p>Discription:[备注]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * <p>Discription:[]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
