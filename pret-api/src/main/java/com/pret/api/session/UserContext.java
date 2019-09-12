package com.pret.api.session;

import com.pret.api.info.EnvInfo;

/**
 * @author jswul
 * @title: UserContext
 * @projectName pert
 * @description: TODO
 * @date 2019/7/159:20
 */
public class UserContext {
    private static final ThreadLocal<EnvInfo> context = new ThreadLocal<>();

    /* *
     * 功能描述: 设置用户信息
     * 〈〉
     * @Param: [userInfo]
            * @Return: void
            * @Author: jswul
            * @Date: 2019/7/15  9:29
     */
    public static void set(EnvInfo envInfo) {
        context.set(envInfo);
    }

    /* *
     * 功能描述: 获取用户信息
     * 〈〉
     * @Param: []
            * @Return: com.pret.api.info.UserInfo
            * @Author: jswul
            * @Date: 2019/7/15  9:29
     */
    public static EnvInfo get() {
        return context.get();
    }

    /* *
     * 功能描述: 移除用户信息
     * 〈〉
     * @Param: []
            * @Return: void
            * @Author: jswul
            * @Date: 2019/7/15  9:30
     */
    public static void remove() {
        context.remove();
    }
}
