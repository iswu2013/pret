package com.pret.common.constant;

/**
 * 错误码
 *
 * @author wujinsong
 */
public enum BEEnum {
    /**
     * 用户不存在
     */
    E90000001("用户不存在", "User does not exist"),
    /**
     * 密码不正确
     */
    E90000002("密码不正确", "Incorrect password"),
    /**
     * 支付失败
     */
    E90000003("支付失败", "Failure to pay"),
    /**
     * 用户余额不够
     */
    E90000004("用户余额不够", "Insufficient user balance"),
    /**
     * 验证码发送失败
     */
    E90000005("验证码发送失败", "Verification Code Failure"),
    /**
     * 该手机号已绑定
     */
    E90000006("该手机号已绑定", "The phone number is bound"),
    /**
     * 该邮件已绑定
     */
    E90000007("该邮件已绑定", "The mailbox is bound"),
    /**
     * 您未发送验证码
     */
    E90000008("您未发送验证码","You did not send the authentication code" ),
    /**
     * 验证码不正确
     */
    E90000009("验证码不正确","Verification code incorrect"),
    /**
     * 验证码已失效
     */
    E90000010("验证码已失效","Verification code is invalid"),
    /**
     * 用户已被禁用
     */
    E90000011("用户已被禁用","Users have been disabled"),
    /**
     * 不可以转账给自己
     */
    E90000012("不可以转账给自己","You can't transfer money to yourself");

    private BEEnum(String msg, String emsg) {
        this.msg = msg;
        this.emsg = emsg;
    }

    private String msg;

    private String emsg;

    public String getMsg(String lang) {
        if (lang.equals(ConstantEnum.ELangType.cn.name())) {
            return msg;
        }
        return emsg;
    }
}
