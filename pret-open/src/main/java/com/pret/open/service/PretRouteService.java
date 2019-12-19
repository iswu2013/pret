package com.pret.open.service;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.common.constant.Constants;
import com.pret.common.util.*;
import com.pret.open.entity.PretRoute;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.U9ReturnBo;
import com.pret.open.entity.vo.PretRouteVo;
import com.pret.open.repository.PretRouteRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description: [pret服务]
 * Created on 2019年09月15日
 *
 * @author <a href="mailto: 1037216275@qq.com">wujinsong</a>
 * @version 1.0
 * Copyright (c) 2019年 极客城堡
 */
@Service
@Transactional(rollbackOn = Exception.class)
public class PretRouteService extends BaseServiceImpl<PretRouteRepository, PretRoute, PretRouteVo> {
    @Value("${sf.url}")
    private String sfUrl;
    @Value("${sf.appSecret}")
    private String appSecret;
    @Value("${sf.appCode}")
    private String appCode;

    @Value("${sf.jcontact}")
    private String jcontact;

    @Value("${sf.jtel}")
    private String jtel;

    @Value("${sf.jaddress}")
    private String jaddress;

    @Value("${sf.storeId}")
    private String storeId;

    public void genThirdMail(PretTransOrder pretTransOrder) {
        JSONObject map = new JSONObject();

        BodyProperty bodyProperty = new BodyProperty();
        // 订单号(非必填)
        map.put("boxNo", pretTransOrder.getDeliveryBillNumber());
        bodyProperty.setBoxNo(pretTransOrder.getDeliveryBillNumber());
        map.put("dispatchNo", pretTransOrder.getDeliveryBillNumber());
        bodyProperty.setDispatchNo(pretTransOrder.getDeliveryBillNumber());
        map.put("storeId", appCode);
        bodyProperty.setStoreId(appCode);
        map.put("count", 1);
        bodyProperty.setCount("1");
        map.put("dcontact", pretTransOrder.getCustomerName());
        bodyProperty.setDcontact(pretTransOrder.getCustomerName());
        // 收件电话(非必填)
        map.put("dtel", pretTransOrder.getCustomerLinkPhone());
        bodyProperty.setDtel(pretTransOrder.getCustomerLinkPhone());
        map.put("daddress", pretTransOrder.getCustomerDetailAddress());
        bodyProperty.setDaddress(pretTransOrder.getCustomerDetailAddress());
        map.put("jcontact", pretTransOrder.getSalesNm());
        bodyProperty.setJcontact(pretTransOrder.getSalesNm());
        map.put("jtel", pretTransOrder.getSalesTel());
        bodyProperty.setJtel(pretTransOrder.getSalesTel());
        map.put("jaddress", pretTransOrder.getServiceRouteOriginAddress());
        bodyProperty.setJaddress(pretTransOrder.getServiceRouteOriginAddress());
        map.put("cargo", "拖寄物");
        bodyProperty.setCargo("拖寄物");
        map.put("payMethod", "1");
        bodyProperty.setPayMethod("1");
        map.put("expressType", "1");
        bodyProperty.setExpressType("1");
        map.put("isReturnTracking", "1");
        bodyProperty.setIsReturnTracking("1");
        String custPayTime = Constants.df2.format(new Date());
        map.put("custPayTime", custPayTime);
        bodyProperty.setCustPayTime(custPayTime);
        try {
            List<HeaderProperty> headerPropertyList = new ArrayList<>();
            HeaderProperty headerProperty = new HeaderProperty();
            headerProperty.setName("appCode");
            headerProperty.setValue(appCode);
            headerPropertyList.add(headerProperty);

            String timestamp = Constants.df2.format(new Date());
            headerProperty = new HeaderProperty();
            headerProperty.setName("timestamp");
            headerProperty.setValue(timestamp);
            headerPropertyList.add(headerProperty);

            headerProperty = new HeaderProperty();
            headerProperty.setName("sign");
            String sign = CommonUtil.generateSign(map, timestamp, appSecret);
            headerProperty.setValue(sign);
            headerPropertyList.add(headerProperty);

            headerProperty = new HeaderProperty();
            headerProperty.setName("Content-Type");
            headerProperty.setValue("application/json");
            headerPropertyList.add(headerProperty);

            headerProperty = new HeaderProperty();
            headerProperty.setName("Accept");
            headerProperty.setValue("application/json");
            headerPropertyList.add(headerProperty);

            JSONObject sendMap = new JSONObject();

            HeadProperty headProperty = new HeadProperty();
            headProperty.setAppCode(appCode);
            headProperty.setSign(sign);
            headProperty.setTimestamp(timestamp);
            Gson gson = new Gson();
            String gsonStr = gson.toJson(headProperty);
            sendMap.put("head", gsonStr);
            sendMap.put("body", gson.toJson(bodyProperty));
            String params = sendMap.toString();
            String result = HttpUtil.post(headerPropertyList, sfUrl, params);
            U9ReturnBo u9ReturnBo = Constants.GSON.fromJson(result, U9ReturnBo.class);
            if (u9ReturnBo.getRtnBool().equals("True")) {
            } else {
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
