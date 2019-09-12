package com.pret.api.info;

import java.util.List;

/**
 * @author jswul
 * @title: BusinessGoodsTypeListInfo
 * @projectName pert
 * @description: 商品分类
 * @date 2019/7/9 14:26
 */
public class BusinessGoodsTypeListInfo {
    private List<BusinessGoodsTypeInfo> businessGoodsTypeInfoList;

    public List<BusinessGoodsTypeInfo> getBusinessGoodsTypeInfoList() {
        return businessGoodsTypeInfoList;
    }

    public void setBusinessGoodsTypeInfoList(List<BusinessGoodsTypeInfo> businessGoodsTypeInfoList) {
        this.businessGoodsTypeInfoList = businessGoodsTypeInfoList;
    }
}
