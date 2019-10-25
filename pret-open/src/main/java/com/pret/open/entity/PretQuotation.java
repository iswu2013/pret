package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pret.common.constant.ConstantEnum;
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
@Table(name = "pret_quotation")
public class PretQuotation extends VersionedAuditableIdEntity implements Serializable {

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
     * 报价单号
     */
    private String no;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 线路id
     */
    private String serviceRouteId;

    /**
     * 对账开始日期
     */
    private Date periodFrom;
    /**
     * 对账截止日期
     */
    private Date periodTo;

    /**
     * 状态
     */
    private int status = ConstantEnum.ECheckStatus.待审核.getLabel();

    /**
     * 审核人
     */
    private String checkUserId;

    /**
     * 审核日期
     */
    private Date checkDate;

    /**
     * 报价明细
     */
    private List<PretQuotationItem> pretQuotationItemList;

    // setter and getter


    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

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
     * <p>Discription:[线路id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getServiceRouteId() {
        return serviceRouteId;
    }

    /**
     * <p>Discription:[线路id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setServiceRouteId(String serviceRouteId) {
        this.serviceRouteId = serviceRouteId;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(Date periodTo) {
        this.periodTo = periodTo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public List<PretQuotationItem> getPretQuotationItemList() {
        return pretQuotationItemList;
    }

    public void setPretQuotationItemList(List<PretQuotationItem> pretQuotationItemList) {
        this.pretQuotationItemList = pretQuotationItemList;
    }
}
