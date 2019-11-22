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
public class PretPickUpPlanModifyDriverBo {
    /**
     * 提货计划id
     */
    private String id;

    /**
     * 预计提货时间
     */
    private Date pickUpTime;

    /**
     *
     */
    private String driverId;

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
}
