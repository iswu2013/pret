package com.pret.api.info;

public class UserInfo extends BaseInfo {
    private String id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户名
     */
    private String userEname;

    /**
     * 用户姓
     */
    private String userSurname;

    /**
     * 1男2女0未知
     */
    private Integer  sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 头像地址
     */
    private String headImg;

    /**
     * 电话号码,存储带区号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登录密码
     */
    private String userPwd;

    /**
     * 护照号
     */
    private String passportNo;

    /**
     * facebook标识
     */
    private String fbAccount;

    /**
     * 微信标识
     */
    private String wechatAccount;

    /**
     * qq标识
     */
    private String qqAccount;

    /**
     * 谷歌标识
     */
    private String googleAccount;

    /**
     * twitter标识
     */
    private String twitterAccount;

    /**
     * whatsapp标识
     */
    private String whatsappAccount;

    /**
     * instagram标识
     */
    private String instagramAccount;

    /**
     * 学号
     */
    private String sno;

    /**
     * 学校名称,中文
     */
    private String school;

    /**
     * 学校名称,英文
     */
    private String eschool;

    /**
     * 状态
     * 0正常
     * 1禁用
     */
    private Integer status;

    /**
     * 邀请码code
     */
    private String yqmCode;

    /**
     * 推送token
     */
    private String pushToken;

    /**
     * 用户token,同一用户同一设备同一次登录唯一
     */
    private String utoken;

    /**
     * 设备标识
     */
    private String deviceInfo;

    /**
     * 账号
     */
    private String account;

    private String ischool;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEname() {
        return userEname;
    }

    public void setUserEname(String userEname) {
        this.userEname = userEname;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getFbAccount() {
        return fbAccount;
    }

    public void setFbAccount(String fbAccount) {
        this.fbAccount = fbAccount;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getQqAccount() {
        return qqAccount;
    }

    public void setQqAccount(String qqAccount) {
        this.qqAccount = qqAccount;
    }

    public String getGoogleAccount() {
        return googleAccount;
    }

    public void setGoogleAccount(String googleAccount) {
        this.googleAccount = googleAccount;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public String getWhatsappAccount() {
        return whatsappAccount;
    }

    public void setWhatsappAccount(String whatsappAccount) {
        this.whatsappAccount = whatsappAccount;
    }

    public String getInstagramAccount() {
        return instagramAccount;
    }

    public void setInstagramAccount(String instagramAccount) {
        this.instagramAccount = instagramAccount;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEschool() {
        return eschool;
    }

    public void setEschool(String eschool) {
        this.eschool = eschool;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getYqmCode() {
        return yqmCode;
    }

    public void setYqmCode(String yqmCode) {
        this.yqmCode = yqmCode;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

    public String getUtoken() {
        return utoken;
    }

    public void setUtoken(String utoken) {
        this.utoken = utoken;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getIschool() {
        return ischool;
    }

    public void setIschool(String ischool) {
        this.ischool = ischool;
    }
}
