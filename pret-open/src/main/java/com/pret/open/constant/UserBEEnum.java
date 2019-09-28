package com.pret.open.constant;

import com.pret.common.constant.ConstantEnum;

/**
 * 错误码
 *
 * @author wujinsong
 */
public enum UserBEEnum {
    /**
     * 用户已经注册
     */
    E90000001("用户已经注册","Users have registered"),
    /**
     * 原密码不正确
     */
    E90000002("原密码不正确","The original password is incorrect"),
    /**
     * 用户不存在
     */
    E90000003("用户不存在","User does not exist"),
    /**
     * 请先绑定手机账号或者邮件
     */
    E90000004("请先绑定手机账号","Please bind your mobile account."),
    /**
     * 密码不正确
     */
    E90000005("密码不正确","Incorrect password"),
    /**
     * 该账号已经绑定
     */
    E90000006("该账号已经绑定","The account is already bound."),
    /**
     * 余额不足
     */
    E90000007("余额不足","Sorry, your credit is running low"),
    /**
     *
     */
    E90000008("优惠券不存在","Coupons do not exist"),
    /**
     * 该手机号已绑定
     */
    E90000009("该手机号已绑定", "The phone number is bound"),
    /**
     * 该邮件已绑定
     */
    E90000010("该邮件已绑定", "The mailbox is bound"),
    /**
     * 您已经参与过活动
     */
    E90000011("您已经参与过活动！", "You have participated in the activities.");

    private UserBEEnum(String msg, String emsg) {
        this.msg = msg;
        this.emsg = emsg;
    }

    private String msg;

    private String emsg;

    public String getMsg() {
            return msg;
    }
}
