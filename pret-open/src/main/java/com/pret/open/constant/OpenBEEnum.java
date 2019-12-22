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
    E90000001("用户已经注册","Users have registered"),
    /**
     * 起运地不存在
     */
    E90000002("起运地不存在","起运地不存在"),
    /**
     * 用户不存在
     */
    E90000003("用户不存在","User does not exist"),
    /**
     * 工厂不存在
     */
    E90000004("工厂不存在","工厂不存在."),
    /**
     * 该微信已经绑定其他角色
     */
    E90000005("该微信已经绑定其他角色","该微信已经绑定其他角色"),
    /**
     * 已做提货计划，不可弃审
     */
    E90000006("已做提货计划，不可弃审","已做提货计划，不可弃审."),
    /**
     * 配送单不存在
     */
    E90000007("配送单不存在","配送单不存在"),
    /**
     *
     */
    E90000008("该比配送单已存在，不允许再次发送","该比配送单已存在，不允许再次发送"),
    /**
     * 不是当前工厂的提货计划，无法操作进厂确认
     */
    E90000009("不是当前工厂的提货计划，无法操作进厂确认", "不是当前工厂的提货计划，无法操作进厂确认"),
    /**
     * 该邮件已绑定
     */
    E90000010("该邮件已绑定", "The mailbox is bound"),
    /**
     * 您已经参与过活动
     */
    E90000011("您已经参与过活动！", "You have participated in the activities.");

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
