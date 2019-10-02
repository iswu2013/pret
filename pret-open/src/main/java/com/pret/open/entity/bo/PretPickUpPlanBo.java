package com.pret.open.entity.bo;

import java.util.Date;

/**
 * @author wujingsong
 * @title: PretPickUpPlanBo
 * @projectName pret
 * @description: TODO
 * @date 2019/10/28:15 上午
 */
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
    private java.util.Date pickUpTime;

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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(String vehicleLength) {
        this.vehicleLength = vehicleLength;
    }
}
