package com.pret.open.entity;

import com.pret.common.VersionedAuditableIdEntity;
import com.pret.open.entity.bo.AreaBo;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * <p>Description: 服务线路 </p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Entity
@Table(name = "pret_service_route")
@Excel("服务线路")
@Data
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
     * 创建人
     */
    @ExcelField(value = "创建人")
    private String username;

    private PretVender pretVender;

    /**
     * 供应商
     */
    private String venderId;

    /**
     *  供应商类别
     */
    private Integer venderType;

    /**
     * 线路明细
     */
    private List<PretServiceRouteItem> pretServiceRouteItemList;

    private List<AreaBo> areaBoList;

    // setter and getter

    @Transient()
    public PretVender getPretVender() {
        return pretVender;
    }

    public void setPretVender(PretVender pretVender) {
        this.pretVender = pretVender;
    }

    @Transient()
    public List<PretServiceRouteItem> getPretServiceRouteItemList() {
        return pretServiceRouteItemList;
    }

    public void setPretServiceRouteItemList(List<PretServiceRouteItem> pretServiceRouteItemList) {
        this.pretServiceRouteItemList = pretServiceRouteItemList;
    }

    @Transient()
    public List<AreaBo> getAreaBoList() {
        return areaBoList;
    }

    public void setAreaBoList(List<AreaBo> areaBoList) {
        this.areaBoList = areaBoList;
    }
}
