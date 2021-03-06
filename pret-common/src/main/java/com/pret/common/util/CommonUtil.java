package com.pret.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * 公共方法
 *
 * @author wujinsong
 */
public class CommonUtil {
    /**
     * 获取sign
     *
     * @param param
     * @return
     */
    public static String getSequenceString(Map<String, Object> param, String appKey, String appSecret) {
        // 拼接appKey 和 appSecret
        //param.put("appKey", Constants.APP_SCRET);
        //param.put("appSecret", Constants.APP_SCRET);

        String str = appKey;
        Collection<String> keyset = param.keySet();
        List<String> list = new ArrayList<String>(keyset);
        // 对key键值按字典升序排序
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (param.get(list.get(i)) == null || list.get(i).equals("sign"))
                break;
            str += list.get(i) + param.get(list.get(i)).toString();
        }
        str += appSecret;
        String result = MD5Util.SharedMD5Util().Md5(str);

        return result;
    }

    public static void main(String[] args) {
        String str = "gawgawgweagewag";
        System.out.println(MD5Util.SharedMD5Util().Md5(str));
    }

    public static String generateSign(Map<String, Object> param, String timestamp, String appSecrets) {
        StringBuilder sb = new StringBuilder();
        Collection<String> keyset = param.keySet();
        List<String> list = new ArrayList<String>(keyset);
        // 对key键值按字典升序排序
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            Object value = param.get(list.get(i));
            if (value != null) {
                sb.append(list.get(i)).append("=").append(value).append("&");
            }
        }

        sb.append(timestamp).append("&").append(appSecrets);
        return DigestUtils.md5Hex(sb.toString());
    }

}
