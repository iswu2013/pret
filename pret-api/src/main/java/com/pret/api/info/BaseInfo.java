package com.pret.api.info;

import com.pret.common.constant.ConstantEnum;

public class BaseInfo {
    private String code;

    private String message;

    private boolean judge;

    private String lang = ConstantEnum.ELangType.en.name();

    private Object ret;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isJudge() {
        return judge;
    }

    public void setJudge(boolean judge) {
        this.judge = judge;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Object getRet() {
        return ret;
    }

    public void setRet(Object ret) {
        this.ret = ret;
    }
}
