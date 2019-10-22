package com.pret.common.util;

import java.util.Map;

/**
 * @author jswul
 * @title: SfUtil
 * @projectName jspxcms
 * @description: TODO
 * @date 2019-09-0618:05
 */
public class SfUtil {
    public static String getOrderServiceRequestXml(Map<String, String> params) {


        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<Request service='OrderService' lang='zh-CN'>");
        strBuilder.append("<Head>" + params.get("clientCode") + "</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<Order").append(" ");
        strBuilder.append("orderid='" + params.get("orderid") + "'").append(" ");
        //返回顺丰运单号
        strBuilder.append("express_type='1'").append(" ");
        //寄件方信息
        strBuilder.append("j_province='" + params.get("j_province") + "'").append(" ");
        strBuilder.append("j_city='" + params.get("j_city") + "'").append(" ");
        strBuilder.append("j_company='" + params.get("j_company") + "'").append(" ");
        strBuilder.append("j_contact='" + params.get("j_contact") + "'").append(" ");
        strBuilder.append("j_tel='" + params.get("j_tel") + "'").append(" ");
        strBuilder.append("j_address='" + params.get("j_address") + "'").append(" ");
        //收件方信息
        strBuilder.append("d_province='" + params.get("d_province") + "'").append(" ");
        strBuilder.append("d_city='" + params.get("d_city") + "'").append(" ");
        strBuilder.append("d_county='" + params.get("d_county") + "'").append(" ");
        strBuilder.append("d_company='" + params.get("d_company") + "'").append(" ");
        strBuilder.append("d_tel='" + params.get("d_tel") + "'").append(" ");
        strBuilder.append("d_contact='" + params.get("d_contact") + "'").append(" ");
        strBuilder.append("d_address='" + params.get("d_address") + "'").append(" ");
        //货物信息
        strBuilder.append("parcel_quantity='1'").append(" ");
        strBuilder.append("pay_method='1'").append(" ");
        strBuilder.append("custid ='" + params.get("custid") + "'").append(" ");
        strBuilder.append("customs_batchs=''").append(" ");
        strBuilder.append("cargo='标牌'").append(">");
      /*  strBuilder.append("<AddedService name='COD' value='1.01' value1='7551234567' />");*/
        strBuilder.append("</Order>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");

        return strBuilder.toString();
    }

    /* *
     * 功能描述: 获取订单路由信息
     * 〈〉
     * @Param: [params]
            * @Return: java.lang.String
            * @Author: wujingsong
            * @Date: 2019/9/12  4:39 下午
     */
    public static String getRouteServiceRequestXml(Map<String, String> params) {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<Request service='RouteService' lang='zh-CN'>");
        strBuilder.append("<Head>" + params.get("clientCode") + "</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<RouteRequest").append(" ");
        strBuilder.append("tracking_type='1'").append(" ");
        strBuilder.append("method_type='1'").append(" ");
        strBuilder.append("tracking_number='" + params.get("mailno") + "'").append(" >");
        strBuilder.append("</RouteRequest>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        return strBuilder.toString();
    }
}
