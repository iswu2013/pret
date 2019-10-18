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
     * 获取司机备货列表
     */
    public static final String H8000000 = "getPickupPlanList.get";

    /**
     * 获取待备货详情
     */
    public static final String H8000001 = "getPickupPlanDetail.get";

    static {
        JOP_HANDLER.put(H1000000, "h1000000");
        JOP_HANDLER.put(H1000001, "h1000001");
        JOP_HANDLER.put(H8000000, "h8000000");
        JOP_HANDLER.put(H8000001, "h8000001");
    }

    static {
        JOP_VO.put(H1000000, P1000000Vo.class);
        JOP_VO.put(H1000001, P1000001Vo.class);
        JOP_VO.put(H8000000, P8000000Vo.class);
        JOP_VO.put(H8000001, P8000001Vo.class);
    }
}
