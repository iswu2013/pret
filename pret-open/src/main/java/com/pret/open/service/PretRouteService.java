package com.pret.open.service;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.pret.api.service.impl.BaseServiceImpl;
import com.pret.common.constant.Constants;
import com.pret.common.util.*;
import com.pret.open.entity.PretPickUpPlan;
import com.pret.open.entity.PretRoute;
import com.pret.open.entity.PretTransOrder;
import com.pret.open.entity.bo.JsonRootBean;
import com.pret.open.entity.bo.U9ReturnBo;
import com.pret.open.entity.vo.PretRouteVo;
import com.pret.open.repository.PretRouteRepository;
import com.pret.open.repository.PretTransOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;

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
        map.put("count", "1");
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
            String timestamp = Constants.df2.format(new Date());
            String sign = CommonUtil.generateSign(map, timestamp, appSecret);
            HeadProperty headProperty = new HeadProperty();
            headProperty.setAppCode(appCode);
            headProperty.setSign(sign);
            headProperty.setTimestamp(timestamp);
            Gson gson = new Gson();
            RequestProperty requestProperty = new RequestProperty();
            requestProperty.setBody(bodyProperty);
            requestProperty.setHead(headProperty);

            String result = HttpUtil.post(sfUrl, gson.toJson(requestProperty));
            JsonRootBean u9ReturnBo = Constants.GSON.fromJson(result, JsonRootBean.class);
            if (u9ReturnBo.isSuccess()) {
                PretTransOrder transOrder = pretTransOrderRepository.findTop1ByMailno(u9ReturnBo.getData().get(0).getMailno());
            } else {
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
