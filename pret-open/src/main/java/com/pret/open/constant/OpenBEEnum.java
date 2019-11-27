package com.pret.open.constant;

/**
 * 错误码
 *
 * @author wujinsong
 */
public enum OpenBEEnum {
    /**
     * 用户已经注册
     */
    E90000001("起运地不存在","起运地不存在");

    private OpenBEEnum(String msg, String emsg) {
        this.msg = msg;
        this.emsg = emsg;
    }

    private String msg;

    private String emsg;

    public String getMsg() {
            return msg;
    }
}
