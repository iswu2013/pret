package com.pret.api.info;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: BusinessInfo
 * @projectName pert
 * @description: 商户
 * @date 2019/7/3 18:34
 */
public class BusinessInfo extends BaseInfo {
    /**
     * id
     */
    private String id;
    /**
     * 学校id,预留
     */
    private String schoolId;

    /**
     * 商家名称,中文
     */
    private String busiName;

    /**
     * 商家名称,英文
     */
    private String busiEname;

    /**
     * 商家简述
     */
    private String busiDesc;

    /**
     * 商家简述,英文
     */
    private String busiEdesc;

    /**
     *  图片logo
     */
    private String busiImgUrl;

    /**
     * 类型
     * 0或空 未知
     * 1餐饮
     * 2商超
     * 3房屋
     * 4二手
     */
    private Integer busiType;

    /**
     * 0正常
     * 1下架
     */
    private Integer status;

    /**
     * 组类型
     * 0外卖
     * 1商城
     * 3房屋
     */
    private Integer groupType;

    /**
     * 起送金额
     */
    private BigDecimal minSendAmount;

    /**
     * 配送费率: 10%
     */
    private BigDecimal sendFeeRate;

    /**
     *  配送费上限
     */
    private BigDecimal sendFeeLimit;

    /**
     * 共享配送费用
     */
    private BigDecimal shareAmount;

    /**
     * 用户承担配送费
     */
    private BigDecimal customSendFee;

    /**
     *  休息状态
     *  0正常
     *  1休息
     */
    private Integer restStatus;

    /**
     * 配送描述,中文
     */
    private String sendTimeDesc;

    /**
     * 配送描述,英文
     */
    private String sendTimeEdesc;

    /**
     *  排序,升序
     */
    private Integer  busiSort;

    /**
     * 营业开始时间
     */
    private String startTime;

    /**
     *  营业结束时间
     */
    private String endTime;

    /**
     * 商家地址,中文
     */
    private String busiAddress;

    /**
     * 商家地址,英文
     */
    private String busiEAddress;

    /**
     * 商家电话
     */
    private String busiMobile;

    /**
     * 营业执照图片
     */
    private String busiLicense;

    /**
     *  法人身份证正面
     */
    private String cardImgObverse;

    /**
     *  法人身份证反面
     */
    private String cardImgRever;

    /**
     *  卫生许可证
     */
    private String healthPermit;

    /**
     * 公告,中文
     */
    private String noticeCont;

    /**
     * 公告,英文
     */
    private String noticeEcont;

    /**
     * 房产证
     */
    private String houseCertificate;

    /**
     * Hmo牌照
     */
    private String hmoCertificate;

    /**
     * 煤气证书
     */
    private String gasCertificate;

    /**
     * 报警器证书
     */
    private String alarmCertificate;

    /**
     * 电的证书
     */
    private String electricityCertificate;

    /**
     *  二维码地址
     */
    private String ewmUrl;

    /**
     * 绑定系统登录号
     */
    private String sysUserName;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 创建人
     */
    private String createLoginName;

    private String ibusiName;

    private String ibusiDesc;

    private String isendTimeDesc;

    private String ibusiAddress;

    private String inoticeCont;

    private String uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    @JsonIgnore()
    public String getBusiName() {
        return busiName;
    }

    public void setBusiName(String busiName) {
        this.busiName = busiName;
    }

    @JsonIgnore()
    public String getBusiEname() {
        return busiEname;
    }

    public void setBusiEname(String busiEname) {
        this.busiEname = busiEname;
    }

    @JsonIgnore()
    public String getBusiDesc() {
        return busiDesc;
    }

    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc;
    }

    @JsonIgnore()
    public String getBusiEdesc() {
        return busiEdesc;
    }

    public void setBusiEdesc(String busiEdesc) {
        this.busiEdesc = busiEdesc;
    }

    public String getBusiImgUrl() {
        return busiImgUrl;
    }

    public void setBusiImgUrl(String busiImgUrl) {
        this.busiImgUrl = busiImgUrl;
    }

    public Integer getBusiType() {
        return busiType;
    }

    public void setBusiType(Integer busiType) {
        this.busiType = busiType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public BigDecimal getMinSendAmount() {
        return minSendAmount;
    }

    public void setMinSendAmount(BigDecimal minSendAmount) {
        this.minSendAmount = minSendAmount;
    }

    public BigDecimal getSendFeeRate() {
        return sendFeeRate;
    }

    public void setSendFeeRate(BigDecimal sendFeeRate) {
        this.sendFeeRate = sendFeeRate;
    }

    public BigDecimal getSendFeeLimit() {
        return sendFeeLimit;
    }

    public void setSendFeeLimit(BigDecimal sendFeeLimit) {
        this.sendFeeLimit = sendFeeLimit;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }

    public BigDecimal getCustomSendFee() {
        return customSendFee;
    }

    public void setCustomSendFee(BigDecimal customSendFee) {
        this.customSendFee = customSendFee;
    }

    public Integer getRestStatus() {
        return restStatus;
    }

    public void setRestStatus(Integer restStatus) {
        this.restStatus = restStatus;
    }

    @JsonIgnore()
    public String getSendTimeDesc() {
        return sendTimeDesc;
    }

    public void setSendTimeDesc(String sendTimeDesc) {
        this.sendTimeDesc = sendTimeDesc;
    }

    @JsonIgnore()
    public String getSendTimeEdesc() {
        return sendTimeEdesc;
    }

    public void setSendTimeEdesc(String sendTimeEdesc) {
        this.sendTimeEdesc = sendTimeEdesc;
    }

    public Integer getBusiSort() {
        return busiSort;
    }

    public void setBusiSort(Integer busiSort) {
        this.busiSort = busiSort;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonIgnore()
    public String getBusiAddress() {
        return busiAddress;
    }

    public void setBusiAddress(String busiAddress) {
        this.busiAddress = busiAddress;
    }

    @JsonIgnore()
    public String getBusiEAddress() {
        return busiEAddress;
    }

    public void setBusiEAddress(String busiEAddress) {
        this.busiEAddress = busiEAddress;
    }

    public String getBusiMobile() {
        return busiMobile;
    }

    public void setBusiMobile(String busiMobile) {
        this.busiMobile = busiMobile;
    }

    public String getBusiLicense() {
        return busiLicense;
    }

    public void setBusiLicense(String busiLicense) {
        this.busiLicense = busiLicense;
    }

    public String getCardImgObverse() {
        return cardImgObverse;
    }

    public void setCardImgObverse(String cardImgObverse) {
        this.cardImgObverse = cardImgObverse;
    }

    public String getCardImgRever() {
        return cardImgRever;
    }

    public void setCardImgRever(String cardImgRever) {
        this.cardImgRever = cardImgRever;
    }

    public String getHealthPermit() {
        return healthPermit;
    }

    public void setHealthPermit(String healthPermit) {
        this.healthPermit = healthPermit;
    }

    @JsonIgnore()
    public String getNoticeCont() {
        return noticeCont;
    }

    public void setNoticeCont(String noticeCont) {
        this.noticeCont = noticeCont;
    }

    @JsonIgnore()
    public String getNoticeEcont() {
        return noticeEcont;
    }

    public void setNoticeEcont(String noticeEcont) {
        this.noticeEcont = noticeEcont;
    }

    public String getHouseCertificate() {
        return houseCertificate;
    }

    public void setHouseCertificate(String houseCertificate) {
        this.houseCertificate = houseCertificate;
    }

    public String getHmoCertificate() {
        return hmoCertificate;
    }

    public void setHmoCertificate(String hmoCertificate) {
        this.hmoCertificate = hmoCertificate;
    }

    public String getGasCertificate() {
        return gasCertificate;
    }

    public void setGasCertificate(String gasCertificate) {
        this.gasCertificate = gasCertificate;
    }

    public String getAlarmCertificate() {
        return alarmCertificate;
    }

    public void setAlarmCertificate(String alarmCertificate) {
        this.alarmCertificate = alarmCertificate;
    }

    public String getElectricityCertificate() {
        return electricityCertificate;
    }

    public void setElectricityCertificate(String electricityCertificate) {
        this.electricityCertificate = electricityCertificate;
    }

    public String getEwmUrl() {
        return ewmUrl;
    }

    public void setEwmUrl(String ewmUrl) {
        this.ewmUrl = ewmUrl;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }

    public String getIbusiName() {
        return ibusiName;
    }

    public void setIbusiName(String ibusiName) {
        this.ibusiName = ibusiName;
    }

    public String getIbusiDesc() {
        return ibusiDesc;
    }

    public void setIbusiDesc(String ibusiDesc) {
        this.ibusiDesc = ibusiDesc;
    }

    public String getIsendTimeDesc() {
        return isendTimeDesc;
    }

    public void setIsendTimeDesc(String isendTimeDesc) {
        this.isendTimeDesc = isendTimeDesc;
    }

    public String getIbusiAddress() {
        return ibusiAddress;
    }

    public void setIbusiAddress(String ibusiAddress) {
        this.ibusiAddress = ibusiAddress;
    }

    public String getInoticeCont() {
        return inoticeCont;
    }

    public void setInoticeCont(String inoticeCont) {
        this.inoticeCont = inoticeCont;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
