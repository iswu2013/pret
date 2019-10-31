package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_service_route")
@Excel("服务线路")
public class PretServiceRoute extends VersionedAuditableIdEntity implements Serializable {

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
     * 线路名称
     */
    @ExcelField(value = "线路名称")
    private String name;

    /**
     * 供应商id
     */
    @ExcelField(value = "供应商id")
    private String venderId;
    /**
     * 起运地,可多个
     */
    private String seviceRouteOrginId;
    /**
     * 计费区间id
     */
    @ExcelField(value = "计费区间id")
    private String billingIntervalId;

    private PretVender pretVender;

    private PretBillingInterval pretBillingInterval;

    /**
     * 起运地名称
     */
    private String seviceRouteOrginName;

    /**
     * 线路明细
     */
    private List<PretServiceRouteItem>  pretServiceRouteItemList;

    // setter and getter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getSeviceRouteOrginId() {
        return seviceRouteOrginId;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setSeviceRouteOrginId(String seviceRouteOrginId) {
        this.seviceRouteOrginId = seviceRouteOrginId;
    }

    /**
     * <p>Discription:[计费区间id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getBillingIntervalId() {
        return billingIntervalId;
    }

    /**
     * <p>Discription:[计费区间id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setBillingIntervalId(String billingIntervalId) {
        this.billingIntervalId = billingIntervalId;
    }

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public PretBillingInterval getPretBillingInterval() {
        return pretBillingInterval;
    }

    public void setPretBillingInterval(PretBillingInterval pretBillingInterval) {
        this.pretBillingInterval = pretBillingInterval;
    }

    @Transient()
    public String getSeviceRouteOrginName() {
        return seviceRouteOrginName;
    }

    public void setSeviceRouteOrginName(String seviceRouteOrginName) {
        this.seviceRouteOrginName = seviceRouteOrginName;
    }

    @Transient()
    public List<PretServiceRouteItem> getPretServiceRouteItemList() {
        return pretServiceRouteItemList;
    }

    public void setPretServiceRouteItemList(List<PretServiceRouteItem> pretServiceRouteItemList) {
        this.pretServiceRouteItemList = pretServiceRouteItemList;
    }
}
