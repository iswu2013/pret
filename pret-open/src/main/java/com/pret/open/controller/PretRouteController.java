package com.pret.open.controller;

import com.pret.api.rest.BaseManageController;
import com.pret.api.vo.LabelValue;
import com.pret.common.annotation.Log;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.msg.ListRestResponse;
import com.pret.common.util.SfUtil;
import com.pret.open.config.Sender;
import com.pret.open.entity.*;
import com.pret.open.entity.vo.PretBillingIntervalVo;
import com.pret.open.entity.vo.PretRouteVo;
import com.pret.open.repository.PretRouteRepository;
import com.pret.open.repository.PretTransPlanRepository;
import com.pret.open.repository.PretVenderRepository;
import com.pret.open.service.PretBillingIntervalService;
import com.pret.open.service.PretRouteService;
import com.sf.csim.express.service.CallExpressServiceTools;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Route;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("pretRoute")
public class PretRouteController extends BaseManageController<PretRouteService, PretRoute, PretRouteVo> {
    @Autowired
    private PretRouteRepository pretRouteRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private Sender sender;
    @Value("${sf.url}")
    private String sfUrl;

    @Log("查看")
    @PostMapping("/view/{id}")
    public PretRoute view(@PathVariable String id) throws FebsException {
        try {
            PretRoute item = this.service.findById(id).get();
            return item;
        } catch (Exception e) {
            message = "查看失败";
            throw new FebsException(message);
        }
    }

    /* *
     * 功能描述: 根据运输计划获取轨迹
     * 〈〉
     * @Param: [id]
     * @Return: java.util.List<okhttp3.Route>
     * @Author: wujingsong
     * @Date: 2019/10/22  5:55 下午
     */
    @RequestMapping(value = "/getByTransPlanId/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<PretRoute> getByTransPlanId(@PathVariable String id) {
        PretTransPlan pretTransPlan = pretTransPlanRepository.findById(id).get();
        return this.getOrderPath(pretTransPlan.getMailno(), pretTransPlan.getId());
    }

    /* *
     * 功能描述: <br>
     * 〈〉
     * @Param: [expressCode, transPlanId]
     * @Return: java.util.List<com.pret.open.entity.PretRoute>
     * @Author: wujingsong
     * @Date: 2019/10/22  7:05 下午
     */
    private List<PretRoute> getOrderPath(String expressCode, String transPlanId) {
        List<PretRoute> mallRouteList = null;
        List<PretRoute> routeList = pretRouteRepository.findByMailnoAndOpcode(expressCode, "80");
        if (routeList != null && routeList.size() > 0) {
            mallRouteList = pretRouteRepository.findByMailno(expressCode);
        } else {
            //组装请求参数
            Map map = new HashMap();
            map.put("clientCode", sender.getClientCode());
            map.put("mailno", expressCode);

            String xmlStr = SfUtil.getRouteServiceRequestXml(map);
            CallExpressServiceTools client = CallExpressServiceTools.getInstance();
            String respXml = client.callSfExpressServiceByCSIM(sfUrl, xmlStr, sender.getClientCode(), sender.getCheckword());
            Document doc = null;
            try {
                // 下面的是通过解析xml字符串的
                // 将字符串转为XML
                doc = DocumentHelper.parseText(respXml);
                //获取根节点元素对象  
                // 获取根节点
                Element root = doc.getRootElement();
                //获取子节点
                String head = root.elementText("Head");
                if (head.equals("OK")) {
                    Element body = root.element("Body");
                    Element routeResponse = body.element("RouteResponse");
                    List<Element> elementList = routeResponse.elements();
                    if (elementList != null && elementList.size() > 0) {
                        List<PretRoute> mallRoutes = pretRouteRepository.findByMailno(expressCode);
                        if (mallRoutes != null && mallRoutes.size() > 0) {
                            pretRouteRepository.deleteByMailno(expressCode);
                        }
                        mallRouteList = new ArrayList<>();
                        for (Element element : elementList) {
                            PretRoute mallRoute = new PretRoute();
                            mallRoute.setAcceptAddress(element.attributeValue("accept_address"));
                            mallRoute.setAcceptTime(element.attributeValue("accept_time"));
                            mallRoute.setRemark(element.attributeValue("remark"));
                            mallRoute.setOpcode(element.attributeValue("opcode"));
                            mallRoute.setTransPlanId(transPlanId);
                            mallRoute.setMailno(expressCode);
                            pretRouteRepository.save(mallRoute);

                            mallRouteList.add(mallRoute);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return mallRouteList;
    }
}