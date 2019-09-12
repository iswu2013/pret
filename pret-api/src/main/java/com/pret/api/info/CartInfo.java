package com.pret.api.info;

/**
 * @author jswul
 * @title: Cart
 * @projectName pert
 * @description: 购物车
 * @date 2019/7/2 19:28
 */
public class CartInfo extends BaseInfo {
    private String id;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 类别：1美食，2商超，3，二手商品
     */
    private  Integer type;

    /**
     * 关联对象id
     */
    private String objId;

    /**
     * 数量
     */
    private  Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
