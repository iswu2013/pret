package com.pret.api.info;

/**
 * @author jswul
 * @title: DeliveryInfo
 * @projectName pert
 * @description: 配送地址
 * @date 2019/7/18 22:53
 */
public class DeliveryInfo extends BaseInfo {
    private String id;

    /**
     * 类型
     * 0美食
     * 1商超
     */
    private String deliveryType;

    /**
     * 配送位置,中文
     */
    private String deliveryName;

    /**
     * 配送位置，英文
     */
    private String deliveryEname;

    /**
     * 状态
     * 0正常
     * 1停用
     */
    private Integer status;

    /**
     * 午餐到达时间
     */
    private String lunchArriveTime;

    /**
     * 晚餐到达时间
     */
    private String dinnerArriveTime;

    /**
     * 创建人
     */
    private String createLoginName;

    /**
     * 中文名或者英文名
     */
    private String iname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getDeliveryEname() {
        return deliveryEname;
    }

    public void setDeliveryEname(String deliveryEname) {
        this.deliveryEname = deliveryEname;
    }

    public String getLunchArriveTime() {
        return lunchArriveTime;
    }

    public void setLunchArriveTime(String lunchArriveTime) {
        this.lunchArriveTime = lunchArriveTime;
    }

    public String getDinnerArriveTime() {
        return dinnerArriveTime;
    }

    public void setDinnerArriveTime(String dinnerArriveTime) {
        this.dinnerArriveTime = dinnerArriveTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }
}
