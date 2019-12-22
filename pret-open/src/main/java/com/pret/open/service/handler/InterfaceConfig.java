package com.pret.open.service.handler;

import com.pret.api.vo.ReqBody;
import com.pret.open.vo.req.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: [pretmodel]</p>
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
public class InterfaceConfig {
    /* 接口处理器 */
    public static final Map<String, String> JOP_HANDLER = new HashMap<String, String>();
    /* 接口处理器 */
    public static final Map<String, Class<? extends ReqBody>> JOP_VO = new HashMap<String, Class<? extends ReqBody>>();

    /**
     * 下单
     */
    public static final String H1000000 = "api.order.do";

    /**
     * 完成备货
     */
    public static final String H1000001 = "finishPickupPlan.do";

    /**
     * 进厂确认
     */
    public static final String H1000002 = "inFactory.do";

    /**
     * 出厂确认
     */
    public static final String H1000003 = "outFactory.do";

    /**
     * 绑定用户
     */
    public static final String H1000004 = "bindUser.do";

    /**
     * 删除订单
     */
    public static final String H1000005 = "api.order.delete.do";

    /**
     * 解析手机号码
     */
    public static final String H1000006 = "resolvePhone.do";

    /**
     * 输入u9code
     */
    public static final String H1000007 = "inputU9Code.do";

    /**
     *  顺丰回调
     */
    public static final String H1000008 = "sfCallbak.do";

    /**
     * 获取司机备货列表
     */
    public static final String H8000000 = "getPickupPlanList.get";

    /**
     * 获取待备货详情
     */
    public static final String H8000001 = "getPickupPlanDetail.get";

    /**
     * 获取用户运输计划
     */
    public static final String H8000002 = "getTransPanList.get";

    /**
     * 获取用户运输计划详情
     */
    public static final String H8000003 = "getTransPlanDetail.get";

    /**
     * 获取司机详情
     */
    public static final String H8000004 = "getDriverDetail.get";

    /**
     * 获取openid
     */
    public static final String H8000005 = "getOpenid.get";

    /**
     * 获取理货员备货列表
     */
    public static final String H8000006 = "getPickupPlanListByTallyClerk.get";

    /**
     * 获取理货员待备货详情
     */
    public static final String H8000007 = "getPickupPlanDetailByTallyClerk.get";

    /**
     * 根据提货计划获取司机详情
     */
    public static final String H8000008 = "getDriveryByPickUpPlanEwm.get";

    /**
     * 获取销售员运输计划
     */
    public static final String H8000009 = "getTransPanListBySale.get";

    /**
     * 获取部门
     */
    public static final String H8000010 = "getDeptList.get";

    /**
     * 获取用户信息
     */
    public static final String H8000011 = "getUserInfo.get";

    static {
        JOP_HANDLER.put(H1000000, "h1000000");
        JOP_HANDLER.put(H1000001, "h1000001");
        JOP_HANDLER.put(H1000002, "h1000002");
        JOP_HANDLER.put(H1000003, "h1000003");
        JOP_HANDLER.put(H1000004, "h1000004");
        JOP_HANDLER.put(H1000005, "h1000005");
        JOP_HANDLER.put(H1000006, "h1000006");
        JOP_HANDLER.put(H1000007, "h1000007");
        JOP_HANDLER.put(H8000000, "h8000000");
        JOP_HANDLER.put(H8000001, "h8000001");
        JOP_HANDLER.put(H8000002, "h8000002");
        JOP_HANDLER.put(H8000003, "h8000003");
        JOP_HANDLER.put(H8000004, "h8000004");
        JOP_HANDLER.put(H8000005, "h8000005");
        JOP_HANDLER.put(H8000006, "h8000006");
        JOP_HANDLER.put(H8000007, "h8000007");
        JOP_HANDLER.put(H8000008, "h8000008");
        JOP_HANDLER.put(H8000009, "h8000009");
        JOP_HANDLER.put(H8000010, "h8000010");
        JOP_HANDLER.put(H8000011, "h8000011");
    }

    static {
        JOP_VO.put(H1000000, P1000000Vo.class);
        JOP_VO.put(H1000001, P1000001Vo.class);
        JOP_VO.put(H1000002, P1000002Vo.class);
        JOP_VO.put(H1000003, P1000003Vo.class);
        JOP_VO.put(H1000004, P1000004Vo.class);
        JOP_VO.put(H1000005, P1000005Vo.class);
        JOP_VO.put(H1000006, P1000006Vo.class);
        JOP_VO.put(H1000007, P1000007Vo.class);
        JOP_VO.put(H8000000, P8000000Vo.class);
        JOP_VO.put(H8000001, P8000001Vo.class);
        JOP_VO.put(H8000002, P8000002Vo.class);
        JOP_VO.put(H8000003, P8000003Vo.class);
        JOP_VO.put(H8000004, P8000004Vo.class);
        JOP_VO.put(H8000005, P8000005Vo.class);
        JOP_VO.put(H8000006, P8000006Vo.class);
        JOP_VO.put(H8000007, P8000007Vo.class);
        JOP_VO.put(H8000008, P8000008Vo.class);
        JOP_VO.put(H8000009, P8000009Vo.class);
        JOP_VO.put(H8000010, P8000010Vo.class);
        JOP_VO.put(H8000011, P8000011Vo.class);
    }
}
