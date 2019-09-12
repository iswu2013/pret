package com.pret.api.info;

/**
 * @author jswul
 * @title: BannerInfo
 * @projectName pert
 * @description: 轮播图
 * @date 2019/7/11 16:19
 */
public class BannerInfo extends BaseInfo {
    private String id;

    /**
     * 连接地址
     */
    private String hrefUrl;

    /**
     * 是否连接
     */
    private Integer isHref;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 学校标识,预留
     */
    private String schoolId;

    /**
     * 板块key
     * 美食food_banner
     * 商超market_banner
     * 二手second_banner
     * 住宿house_banner
     * 规则key：类别id+标签id
     */
    private String plateKey;

    /**
     * 排序
     */
    private Integer imgSort;

    /**
     * 状态
     * 0正常
     * 1下架
     */
    private Integer status;

    /**
     * 创建人
     */
    private String createLoginName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHrefUrl() {
        return hrefUrl;
    }

    public void setHrefUrl(String hrefUrl) {
        this.hrefUrl = hrefUrl;
    }

    public Integer getIsHref() {
        return isHref;
    }

    public void setIsHref(Integer isHref) {
        this.isHref = isHref;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getPlateKey() {
        return plateKey;
    }

    public void setPlateKey(String plateKey) {
        this.plateKey = plateKey;
    }

    public Integer getImgSort() {
        return imgSort;
    }

    public void setImgSort(Integer imgSort) {
        this.imgSort = imgSort;
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
}
