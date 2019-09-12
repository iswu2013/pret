package com.pret.common.constant;

import com.google.gson.Gson;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CommonConstants {
    public final static String RESOURCE_TYPE_MENU = "menu";
    public final static String RESOURCE_TYPE_BTN = "button";
    public static final Integer EX_TOKEN_ERROR_CODE = 40101;
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40102;
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40131;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
    /**
     * 查询条件标识
     */
    public static final String QUERY_MARKER = "$";

    /**
     * Gson
     */
    public static final Gson GSON = new Gson();

    /**
     * 年月日时分秒
     */
    public static FastDateFormat df2 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static FastDateFormat dfyyyyMMddHHmmssSSS = FastDateFormat.getInstance("yyyyMMddHHmmssSSS");

    public static final Long MILLISECOND_60000 = 60000l;

    public static final String CONTRACT_ROOT = "/home/upload/";

    public static final String Earliest_Delivery_CN = "最早配送";

    public static final String Earliest_Delivery_EN = "Earliest delivery";

    public final static long ONE_Minute = 60 * 1000;
    public final static long ONE = 1 * 1000;
    public final static long Two_Hour = 60 * 1000 * 60 * 2;

    public final static long Minute_15 = 60 * 1000 * 15;

    public final static String DEFAULT_PWD = "123456";

    public final static String NICK_NAME = "nickname";

    public final static String jg_app_key = "da056e2d750200578c1cea10";

    public final static String jq_secret = "8dc997b1c61476c48d4a650b";
}
