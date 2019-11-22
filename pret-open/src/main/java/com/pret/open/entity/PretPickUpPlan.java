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
 * <p>Description: 提货计划</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_pick_up_plan")
@Excel("提货计划")
@Data
public class PretPickUpPlan extends VersionedAuditableIdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
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
    private String no;

    /**
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;

    /**
     * 类型
     */
    @ExcelField(value = "类型")
    private String type;

    /**
     * 预计提货时间
     */
    @ExcelField(value = "预计提货时间", writeConverter = TimeConverter.class)
    private Date pickUpTime;

    /**
     * 司机
     */
    @ExcelField(value = "司机")
    private String driverId;

    /**
     * 提货数量
     */
    @ExcelField(value = "提货数量")
    private Integer count;

    /**
     * 提货重量
     */
    @ExcelField(value = "提货重量")
    private String weight;

    /**
     * 0待提货1已完成
     */
    @ExcelField(value = "状态", writeConverterExp = "0=待提货,1=已完成")
    private Integer status = ConstantEnum.EPretPickUpPlanStatus.待提货.getLabel();

    /**
     * 实际提货时间
     */
    @ExcelField(value = "实际提货时间", writeConverter = TimeConverter.class)
    private Date startTime;

    /**
     * 结束提货时间
     */
    @ExcelField(value = "结束提货时间", writeConverter = TimeConverter.class)
    private Date endTime;

    /**
     * 二维码内容
     */
    private String qrcode;

    /**
     * 二维码存储地址
     */
    private String qrcodePath;

    /**
     * 提货地Id
     */
    private String serviceRouteOriginId;

    /**
     * 司机姓名
     */
    private String name;
    /**
     * 司机电话
     */
    private String phone;
    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 运输任务单
     */
    private List<PretTransOrder> transOrderList;

    /**
     * 供应商
     */
    private PretVender pretVender;

    /**
     * 司机
     */
    private PretDriver pretDriver;

    private PretServiceRouteOrigin pretServiceRouteOrigin;

    // setter and getter

    @Transient()
    public List<PretTransOrder> getTransOrderList() {
        return transOrderList;
    }

    public void setTransOrderList(List<PretTransOrder> transOrderList) {
        this.transOrderList = transOrderList;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretDriver getPretDriver() {
        return pretDriver;
    }

    public void setPretDriver(PretDriver pretDriver) {
        this.pretDriver = pretDriver;
    }

    @Transient()
    public PretServiceRouteOrigin getPretServiceRouteOrigin() {
        return pretServiceRouteOrigin;
    }

    public void setPretServiceRouteOrigin(PretServiceRouteOrigin pretServiceRouteOrigin) {
        this.pretServiceRouteOrigin = pretServiceRouteOrigin;
    }
}
