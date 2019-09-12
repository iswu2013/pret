package com.pret.api.info;

/**
 * @author jswul
 * @title: OrderEvaluateInfo
 * @projectName pert
 * @description: TODO
 * @date 2019/7/413:28
 */
public class OrderEvaluateInfo extends BaseInfo {
    /**
     * id
     */
    private String id;
    /**
     * 商品id
     */
    private String objId;

    /**
     * 类别
     */
    private Integer objType;

    /**
     * 业务订单号
     */
    private String orderNo;

    /**
     * 评价内容
     */
    private String evalDesc;

    /**
     * 评价内容,预留
     */
    private String evalEdesc;

    /**
     * 口味评级
     */
    private Float flavorGrade;

    /**
     * 服务评级
     */
    private Float serviceGrade;

    /**
     * 状态
     * 0待审核（默认）
     * 1正常
     * 2删除
     */
    private Integer status;

    /**
     * 评价人
     */
    private String uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public Integer getObjType() {
        return objType;
    }

    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEvalDesc() {
        return evalDesc;
    }

    public void setEvalDesc(String evalDesc) {
        this.evalDesc = evalDesc;
    }

    public String getEvalEdesc() {
        return evalEdesc;
    }

    public void setEvalEdesc(String evalEdesc) {
        this.evalEdesc = evalEdesc;
    }

    public Float getFlavorGrade() {
        return flavorGrade;
    }

    public void setFlavorGrade(Float flavorGrade) {
        this.flavorGrade = flavorGrade;
    }

    public Float getServiceGrade() {
        return serviceGrade;
    }

    public void setServiceGrade(Float serviceGrade) {
        this.serviceGrade = serviceGrade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
