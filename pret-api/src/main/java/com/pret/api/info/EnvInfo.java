package com.pret.api.info;

/**
 * @author jswul
 * @title: EnvInfo
 * @projectName pert
 * @description: 环境信息
 * @date 2019/7/15 9:34
 */
public class EnvInfo {
    private UserInfo userInfo;

    private String lang;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
