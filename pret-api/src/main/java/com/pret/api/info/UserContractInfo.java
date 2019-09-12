package com.pret.api.info;

import com.pret.common.constant.ConstantEnum;

import java.math.BigDecimal;

/**
 * @author jswul
 * @title: UserContractInfo
 * @projectName pert
 * @description: 租户合同详细信息
 * @date 2019/7/8 8:44
 */
public class UserContractInfo extends BaseInfo {
    /**
     * id
     */
    private String id;
    /**
     * 订单号,规则UC开头
     */
    private String orderNo;

    /**
     * 合同模板编号
     */
    private String ctCode;

    /**
     * 合同编号
     */
    private String contractCode;

    /**
     * 合同总金额,租金总额+押金
     */
    private BigDecimal contractAmount;

    /**
     * 租金,单价
     */
    private BigDecimal rentAmount;

    /**
     * 押金金额
     */
    private BigDecimal pledgeAmount;

    /**
     * 开始时间
     */
    private String startDate;

    /**
     * 截至时间
     */
    private String endDate;

    /**
     * 几周
     */
    private Integer weekNum;

    /**
     * 多少天
     */
    private Integer weekDay;

    /**
     * 状态
     * 0正常
     * 1到期
     */
    private Integer status;

    /**
     * 名
     */
    private String userName;

    /**
     * 姓
     */
    private String userSurname;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 性别
     * 0未知
     * 1男
     * 2女
     */
    private Integer sex;

    /**
     * 手机号
     * 带区号存储
     */
    private String mobile;

    /**
     * 当前地址
     */
    private String nowAddress;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 城市
     */
    private String city;

    /**
     * 护照号
     */
    private String passportNo;

    /**
     * 护照图片地址
     */
    private String passportImg;

    /**
     * 支付状态
     * 0 未支付
     * 1 已支付
     * 2 退款
     * 4已取消
     */
    private Integer payStatus = ConstantEnum.EPayStatus.未支付.getValue();

    /**
     * 租约人
     */
    private String uid;

    /**
     * 合同本地文件路径
     */
    private String contractPath;

    /**
     * 合同下载地址
     */
    private String contractUrl;

    /**
     * 房源id
     */
    private String  houseId;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCtCode() {
        return ctCode;
    }

    public void setCtCode(String ctCode) {
        this.ctCode = ctCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(BigDecimal rentAmount) {
        this.rentAmount = rentAmount;
    }

    public BigDecimal getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(BigDecimal pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNowAddress() {
        return nowAddress;
    }

    public void setNowAddress(String nowAddress) {
        this.nowAddress = nowAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportImg() {
        return passportImg;
    }

    public void setPassportImg(String passportImg) {
        this.passportImg = passportImg;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getContractPath() {
        return contractPath;
    }

    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getCreateLoginName() {
        return createLoginName;
    }

    public void setCreateLoginName(String createLoginName) {
        this.createLoginName = createLoginName;
    }
}
