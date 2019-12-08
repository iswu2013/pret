package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.converter.TimeConverter;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>Description: 运输异常</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_trans_exception")
@Excel("运输异常")
@Data
public class PretTransException extends VersionedAuditableIdEntity implements Serializable {

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
     * 单号
     */
    @ExcelField(value = "单号")
    private String no;

    /**
     * 运输计划id
     */
    @ExcelField(value = "运输计划id")
    private String transPlanId;

    /**
     * 状态0待审核1通过2不通过
     */
    @ExcelField(value = "状态", writeConverterExp = "0=待认定,1=已认定,2=处理中,3=已结案")
    private Integer status = ConstantEnum.ETransExceptionStatus.待认定.getLabel();

    /**
     * 处理方式
     */
    @ExcelField(value = "处理方式")
    private Integer handleStyle;

    /**
     * 处理状态0未处理1已处理
     */
    private Integer handleStatus = 0;

    /**
     * 责任方0物流1客户2工厂
     */
    @ExcelField(value = "责任方", writeConverterExp = "0=物流,1=客户,2=工厂")
    private Integer responsibleParty;

    /**
     * 处理时间
     */
    @ExcelField(value = "处理时间", writeConverter = TimeConverter.class)
    private Date handleTime;

    /**
     * 物流供应商
     */
    @ExcelField(value = "物流供应商")
    private String venderId;

    /**
     *
     */
    @ExcelField(value = "拒收数量")
    private Float rejectCount;

    /**
     * 是否运回0无1是2否
     */
    private Integer isReturnStatus = 0;

    /**
     * 退回状态，0无1已退回2未退回
     */
    private Integer returnStatus = 0;

    /**
     * 返回至1提货工厂2其他地址
     */
    private Integer returnType;

    /**
     * 退回地址
     */
    private String returnAddress;

    /**
     * 联系人
     */
    private String linkName;

    /**
     * 联系电话
     */
    private String linkPhone;

    /**
     * 退回地址
     */
    private String addressId;

    /**
     * 退回地址详情
     */
    private String addressDetail;

    /**
     * 退回运输单号
     */
    private String transNo;

    /**
     * 是否结退回运费0无1是2否
     */
    private Integer returnFeeStatus;

    /**
     * 赔偿金额
     */
    private BigDecimal compensation;

    /**
     * 赔款状态0无1已赔款2未赔款
     */
    private Integer compensationStatus = ConstantEnum.ECompensationStatus.无赔款.getLabel();

    /**
     * 异常关闭日期
     */
    private long closeTime;

    /**
     * 客户id
     */
    private String customerId;

    /**
     * 是否创建返程
     */
    private Integer createdReturn = ConstantEnum.EcreatedReturn.否.getLabel();

    /**
     * 客户
     */
    private PretCustomer pretCustomer;

    private PretVender pretVender;

    private PretTransPlan pretTransPlan;

    private PretTransOrder pretTransOrder;

    private PretTransFee pretTransFee;

    private List<PretTransExceptionItem> pretTransExceptionItemList;

    private List<PretTransExceptionHandleRecord> pretTransExceptionHandleRecordList;

    // setter and getter

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretTransPlan getPretTransPlan() {
        return pretTransPlan;
    }

    public void setPretTransPlan(PretTransPlan pretTransPlan) {
        this.pretTransPlan = pretTransPlan;
    }

    @Transient()
    public PretTransOrder getPretTransOrder() {
        return pretTransOrder;
    }

    public void setPretTransOrder(PretTransOrder pretTransOrder) {
        this.pretTransOrder = pretTransOrder;
    }

    @Transient()
    public List<PretTransExceptionItem> getPretTransExceptionItemList() {
        return pretTransExceptionItemList;
    }

    public void setPretTransExceptionItemList(List<PretTransExceptionItem> pretTransExceptionItemList) {
        this.pretTransExceptionItemList = pretTransExceptionItemList;
    }

    @Transient()
    public PretCustomer getPretCustomer() {
        return pretCustomer;
    }

    public void setPretCustomer(PretCustomer pretCustomer) {
        this.pretCustomer = pretCustomer;
    }

    @Transient()
    public List<PretTransExceptionHandleRecord> getPretTransExceptionHandleRecordList() {
        return pretTransExceptionHandleRecordList;
    }

    public void setPretTransExceptionHandleRecordList(List<PretTransExceptionHandleRecord> pretTransExceptionHandleRecordList) {
        this.pretTransExceptionHandleRecordList = pretTransExceptionHandleRecordList;
    }

    @Transient()
    public PretTransFee getPretTransFee() {
        return pretTransFee;
    }

    public void setPretTransFee(PretTransFee pretTransFee) {
        this.pretTransFee = pretTransFee;
    }
}
