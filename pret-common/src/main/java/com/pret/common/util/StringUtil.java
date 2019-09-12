package com.pret.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class StringUtil {
    public static String getObjectValue(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * @param ids
     * @return
     */
    public static List<Long> idsStr2List(String ids) {
        List<Long> idList = new ArrayList<>();

        if (!StringUtils.isEmpty(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                if (!StringUtils.isEmpty(id)) {
                    idList.add(Long.parseLong(id));
                }
            }
        }

        return idList;
    }

    public static List<Integer> idsStr2IntegerList(String ids) {
        List<Integer> idList = new ArrayList<>();

        if (!StringUtils.isEmpty(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                if (!StringUtils.isEmpty(id)) {
                    idList.add(Integer.parseInt(id));
                }
            }
        }

        return idList;
    }

    public static List<String> idsStr2ListString(String ids) {
        List<String> idList = new ArrayList<>();

        if (!StringUtils.isEmpty(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                if (!StringUtils.isEmpty(id)) {
                    idList.add(id);
                }
            }
        }
        return idList;
    }

    /**
     * 排序
     *
     * @param ids
     * @return
     */
    public static String idsStr2ListAndSortAsc(String ids) {
        List<Long> idList = new ArrayList<>();

        if (!StringUtils.isEmpty(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                if (!StringUtils.isEmpty(id)) {
                    idList.add(Long.parseLong(id));
                }
            }
        }

        Collections.sort(idList);
        StringBuilder sb = new StringBuilder();
        for (Long id : idList) {
            sb.append(id).append(",");
        }
        String result = sb.toString().substring(0, sb.length() - 1);

        return result;
    }

    /**
     * @param ids
     * @param sub
     * @return
     */
    public static String idsStr2ListAndSubAndSortAsc(String ids, Long sub) {
        List<Long> idList = new ArrayList<>();

        if (!StringUtils.isEmpty(ids)) {
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                if (!StringUtils.isEmpty(id)) {
                    if (!id.equals(sub.toString())) {
                        idList.add(Long.parseLong(id));
                    }
                }
            }
        }

        Collections.sort(idList);
        StringBuilder sb = new StringBuilder();
        for (Long id : idList) {
            sb.append(id).append(",");
        }
        String result = sb.toString().substring(0, sb.length() - 1);

        return result;
    }


    /* *
     * 功能描述: 除掉前导0
     * 〈〉
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: jswul
     * @Date: 2019/6/30  20:27
     */
    public static String disposeFrontZero(String str) {
        String newStr = str.replaceAll("^(0+)", "");

        return newStr;
    }

    /* *
     * 功能描述: 前面加0达到多少位数
     * 〈〉
     * @Param: [str, digit]
     * @Return: java.lang.String
     * @Author: jswul
     * @Date: 2019/6/30  20:28
     */
    public static String addFrontZero(String str, int digit) {
        int needAdd = digit - str.length();
        StringBuilder sb = new StringBuilder();
        if (needAdd >= 0) {
            for (int i = 0; i < needAdd; i++) {
                sb.append("0");
            }
        }
        sb.append(str);

        return sb.toString();
    }

    public static double getDistance(double longitude1, double latitude1, double longitude2, double latitude2) {
        double radLat1 = rad(latitude1);
        double radLat2 = rad(latitude2);
        double a = radLat1 - radLat2;
        double b = rad(longitude1) - rad(longitude2);
        double c = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        c = c * 6378.137;
        return (Math.round(c * 10000d) / 10000d) * 1000;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
