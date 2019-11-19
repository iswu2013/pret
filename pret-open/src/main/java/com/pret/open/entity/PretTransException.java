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
     * 异常类别0
     */
    @ExcelField(value = "异常类别")
    private Integer type;

    /**
     * 状态0待审核1通过2不通过
     */
    @ExcelField(value = "货物类型", writeConverterExp = "0=待审核,1=通过,2=不通过")
    private Integer status = ConstantEnum.ECheckStatus.待审核.getLabel();

    /**
     * 处理方式
     */
    @ExcelField(value = "处理方式")
    private Integer handleStyle;

    /**
     * 责任方0物流1货主2客户
     */
    @ExcelField(value = "责任方", writeConverterExp = "0=物流,1=货主,2=客户")
    private Integer responsibleParty;

    /**
     * 处理时间
     */
    @ExcelField(value = "处理时间", writeConverter = TimeConverter.class)
    private Date handleTime;

    /**
     * 处理人
     */
    @ExcelField(value = "处理人")
    private String handleBy;

    /**
     * 物流供应商
     */
    @ExcelField(value = "物流供应商")
    private String venderId;

    /**
     *
     */
    @ExcelField(value = "拒收数量")
    private Integer rejectCount;

    /**
     * 处理状态
     */
    private Integer handleStatus;

    private PretVender pretVender;

    private PretTransPlan pretTransPlan;

    private PretTransOrder pretTransOrder;

    private List<PretTransExceptionItem> pretTransExceptionItemList;

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
}
