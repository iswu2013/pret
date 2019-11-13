package com.pret.open.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author wujingsong
 * @title: PretPickUpPlanBo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/28:15 上午
 */
@Data
public class PretPickUpPlanBo {
    /**
     * 订单id
     */
    private String ids;

    /**
     * 编号
     */
    private String no;
    /**
     * 供应商id
     */
    private String venderId;
    /**
     * 类型
     */
    private String type;
    /**
     * 预计提货时间
     */
    private Date pickUpTime;

    /**
     *
     */
    private String driverId;
    /**
     * 提货数量
     */
    private Integer count;
    /**
     * 提货重量
     */
    private String weight;

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
     * 车型
     */
    private String vehicleType;

    /**
     * 车长
     */
    private String vehicleLength;
}
