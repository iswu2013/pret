package com.pret.open.entity.bo;

import com.pret.common.VersionedAuditableIdEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Description: 运输计划</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretTransPlanBo {
    /**
     * 订单id
     */
    private String ids;

    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 客户id
     */
    private String customerId;
    /**
     * 预计提货日期
     */
    private java.util.Date transDatetime;
    /**
     * 原始运输计划id,针对异常退货
     */
    private String orginId;
    /**
     * 起运地id
     */
    private String orgId;
    /**
     * 起运地
     */
    private String orgAddress;
    /**
     * 目的地id
     */
    private String destId;
    /**
     * 目的地
     */
    private String destAddress;
    /**
     * 司机id
     */
    private String driverId;
    /**
     * 提货数量
     */
    private Integer count;
    /**
     * 重物数量
     */
    private Integer gw;
    /**
     * 重物单位重
     */
    private String cbm;
    /**
     * 泡物数量
     */
    private Integer cw;
    /**
     * 泡物单位立方
     */
    private String unit;

    // setter and getter


    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
     * <p>Discription:[客户id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * <p>Discription:[客户id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * <p>Discription:[预计提货日期]</p>
     * Created on 2019年09月15日
     *
     * @return java.util.Date
     * @author:wujinsong
     */
    public java.util.Date getTransDatetime() {
        return transDatetime;
    }

    /**
     * <p>Discription:[预计提货日期]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setTransDatetime(java.util.Date transDatetime) {
        this.transDatetime = transDatetime;
    }

    /**
     * <p>Discription:[原始运输计划id,针对异常退货]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrginId() {
        return orginId;
    }

    /**
     * <p>Discription:[原始运输计划id,针对异常退货]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrginId(String orginId) {
        this.orginId = orginId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * <p>Discription:[起运地id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * <p>Discription:[起运地]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    /**
     * <p>Discription:[目的地id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDestId() {
        return destId;
    }

    /**
     * <p>Discription:[目的地id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDestId(String destId) {
        this.destId = destId;
    }

    /**
     * <p>Discription:[目的地]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDestAddress() {
        return destAddress;
    }

    /**
     * <p>Discription:[目的地]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }

    /**
     * <p>Discription:[司机id]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getDriverId() {
        return driverId;
    }

    /**
     * <p>Discription:[司机id]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    /**
     * <p>Discription:[提货数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCount() {
        return count;
    }

    /**
     * <p>Discription:[提货数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * <p>Discription:[重物数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getGw() {
        return gw;
    }

    /**
     * <p>Discription:[重物数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setGw(Integer gw) {
        this.gw = gw;
    }

    /**
     * <p>Discription:[重物单位重]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getCbm() {
        return cbm;
    }

    /**
     * <p>Discription:[重物单位重]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCbm(String cbm) {
        this.cbm = cbm;
    }

    /**
     * <p>Discription:[泡物数量]</p>
     * Created on 2019年09月15日
     *
     * @return Integer
     * @author:wujinsong
     */
    public Integer getCw() {
        return cw;
    }

    /**
     * <p>Discription:[泡物数量]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setCw(Integer cw) {
        this.cw = cw;
    }

    /**
     * <p>Discription:[泡物单位立方]</p>
     * Created on 2019年09月15日
     *
     * @return String
     * @author:wujinsong
     */
    public String getUnit() {
        return unit;
    }

    /**
     * <p>Discription:[泡物单位立方]</p>
     * Created on 2019年09月15日
     *
     * @author:wujinsong
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
}
