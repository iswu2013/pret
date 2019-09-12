package com.pret.api.info;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jswul
 * @title: BusinessGoodsTypeInfo
 * @projectName pert
 * @description: 商品分类
 * @date 2019/7/5 19:36
 */
public class BusinessGoodsTypeInfo extends BaseInfo {
    private String id;

    /**
     * 名称,中文
     */
    private String typeName;

    /**
     * 名称，英文
     */
    private String typeEname;

    /**
     * 类别：美食(0),商超(1),二手(2),房源(3);
     */
    private Integer category;

    /**
     * 商户id
     */
    private String busiId;

    /**
     * 父级id
     */
    private String parentId;

    /**
     * 状态
     * 0正常
     * 1取消
     */
    private Integer status;

    /**
     * 升序规则
     */
    private Integer typeSort;

    /**
     * 创建人
     */
    private String createLoginName;

    private String itypeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore()
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @JsonIgnore()
    public String getTypeEname() {
        return typeEname;
    }

    public void setTypeEname(String typeEname) {
        this.typeEname = typeEname;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTypeSort() {
        return typeSort;
    }

    public void setTypeSort(Integer typeSort) {
        this.typeSort = typeSort;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }

    public String getItypeName() {
        return itypeName;
    }

    public void setItypeName(String itypeName) {
        this.itypeName = itypeName;
    }
}
