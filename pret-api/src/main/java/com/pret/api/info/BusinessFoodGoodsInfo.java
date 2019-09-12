package com.pret.api.info;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: BusinessFoodGoodsInfo
 * @projectName pert
 * @description: 美食
 * @date 2019/6/20 23:23
 */
public class BusinessFoodGoodsInfo extends BaseInfo {
    private String id;

    /**
     * 商户id
     */
    private String busiId;

    /**
     * 商品分类id
     */
    private String typeId;

    /**
     *  商品名称,中文
     */
    private String goodsName;

    /**
     * 商品名称,英文
     */
    private String goodsEname;

    /**
     * 商品图片,首图
     */
    private String goodsImgUrl;

    /**
     * 多图key
     */
    private String goodsImgKey;

    /**
     * 商品描述,中文
     */
    private String goodsDesc;

    /**
     * 商品描述，英文
     */
    private String goodsEdesc;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 折后价格
     */
    private BigDecimal discountPrice;

    /**
     * 是否启用折扣
     * 0不启用
     * 1启用
     */
    private Integer isStartDiscount;

    /**
     * 包装费
     */
    private BigDecimal packingFee;

    /**
     * 库存量
     */
    private Long stockCount;

    /**
     * 总销量
     */
    private Long sellCount;

    /**
     * 是否推荐
     * 0默认
     * 1推荐
     */
    private Integer isRecommend;

    /**
     * 评级;如1.5星
     */
    private Float grade;

    /**
     * 标签ids
     */
    private String tags;

    /**
     * 英文逗号分隔
     */
    private String lastOrderTime;

    /**
     * 状态
     * 0正常
     * 1下架
     */
    private Integer status;

    /**
     * 排序,升序
     */
    private Integer goodsSort;

    /**
     *
     */
    private String igoodsName;

    private String igoodsDesc;

    private String tagsName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsEname() {
        return goodsEname;
    }

    public void setGoodsEname(String goodsEname) {
        this.goodsEname = goodsEname;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public String getGoodsImgKey() {
        return goodsImgKey;
    }

    public void setGoodsImgKey(String goodsImgKey) {
        this.goodsImgKey = goodsImgKey;
    }

    @JsonIgnore()
    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    @JsonIgnore()
    public String getGoodsEdesc() {
        return goodsEdesc;
    }

    public void setGoodsEdesc(String goodsEdesc) {
        this.goodsEdesc = goodsEdesc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getIsStartDiscount() {
        return isStartDiscount;
    }

    public void setIsStartDiscount(Integer isStartDiscount) {
        this.isStartDiscount = isStartDiscount;
    }

    public BigDecimal getPackingFee() {
        return packingFee;
    }

    public void setPackingFee(BigDecimal packingFee) {
        this.packingFee = packingFee;
    }

    public Long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }

    public Long getSellCount() {
        return sellCount;
    }

    public void setSellCount(Long sellCount) {
        this.sellCount = sellCount;
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLastOrderTime() {
        return lastOrderTime;
    }

    public void setLastOrderTime(String lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(Integer goodsSort) {
        this.goodsSort = goodsSort;
    }

    public String getIgoodsName() {
        return igoodsName;
    }

    public void setIgoodsName(String igoodsName) {
        this.igoodsName = igoodsName;
    }

    public String getIgoodsDesc() {
        return igoodsDesc;
    }

    public void setIgoodsDesc(String igoodsDesc) {
        this.igoodsDesc = igoodsDesc;
    }

    public String getTagsName() {
        return tagsName;
    }

    public void setTagsName(String tagsName) {
        this.tagsName = tagsName;
    }
}
