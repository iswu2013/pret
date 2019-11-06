package com.pret.open.entity.bo;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class PretTransExceptionItemBo {
    /**
     * 运输任务单明细id
     */
    private String transOrderId;
    /**
     * 异常类别0
     */
    private Integer type;

    /**
     * 异常描述
     */
    private String remark;
    /**
     * 图片id
     */
    private String picIds;
    /**
     * 异常数量
     */
    private Integer count;

    // setter and getter


    public String getTransOrderId() {
        return transOrderId;
    }

    public void setTransOrderId(String transOrderId) {
        this.transOrderId = transOrderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPicIds() {
        return picIds;
    }

    public void setPicIds(String picIds) {
        this.picIds = picIds;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
