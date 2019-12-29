package com.pret.open.rest;

import com.google.common.base.Joiner;
import com.pret.api.rest.BaseController;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.ConstantEnum;
import com.pret.common.exception.FebsException;
import com.pret.common.utils.FileStringUtil;
import com.pret.open.entity.*;
import com.pret.open.entity.bo.PretTransPlanBo;
import com.pret.open.entity.bo.PretTransPlanSignBo;
import com.pret.open.repository.*;
import com.pret.open.service.PretTransPlanService;
import com.pret.open.service.handler.InterfaceConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @author wujinsong
 */
@Controller
@RequestMapping(value = "/rest")
public class ApiController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
    // 不需要登录的接口
    public static final Map<String, String> UN_LOGIN_MAP = new HashMap<String, String>();
    @Autowired
    private PretTransPlanService pretTransPlanService;
    @Autowired
    private PretTransOrderRepository pretTransOrderRepository;
    @Autowired
    private PretTransPlanRepository pretTransPlanRepository;
    @Autowired
    private PretRouteRepository pretRouteRepository;
    @Autowired
    private PretVenderRepository pretVenderRepository;
    @Autowired
    private PretTransRecordRepository pretTransRecordRepository;

    static {
        /**
         * 业务用户注册接口
         */
//        UN_LOGIN_MAP.put(InterfaceConfig.HMallGoodsDetail,InterfaceConfig.HMallGoodsDetail);

        UN_LOGIN_MAP.put(InterfaceConfig.H1000000, InterfaceConfig.H1000000);
        UN_LOGIN_MAP.put(InterfaceConfig.H1000004, InterfaceConfig.H1000004);
        UN_LOGIN_MAP.put(InterfaceConfig.H1000005, InterfaceConfig.H1000005);
        UN_LOGIN_MAP.put(InterfaceConfig.H1000006, InterfaceConfig.H1000006);
        UN_LOGIN_MAP.put(InterfaceConfig.H1000007, InterfaceConfig.H1000007);
        UN_LOGIN_MAP.put(InterfaceConfig.H8000005, InterfaceConfig.H8000005);
        UN_LOGIN_MAP.put(InterfaceConfig.H8000010, InterfaceConfig.H8000010);
        UN_LOGIN_MAP.put(InterfaceConfig.H8000011, InterfaceConfig.H8000011);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResBody handle(HttpServletRequest httpServletRequest, String method, String v)
            throws IOException, InterruptedException {
        return this.handle(httpServletRequest, method, v, InterfaceConfig.JOP_VO, InterfaceConfig.JOP_HANDLER, UN_LOGIN_MAP, null);
    }

    @ResponseBody
    @PostMapping("/callback")
    public void Callback(String content, HttpServletRequest request, HttpServletResponse response) {
        String respXml = "";
        try {
            // 1. URL解码
            respXml = URLDecoder.decode(content, "UTF-8");
            // 2. Xml转javabean
            SfExpressRequest result = (SfExpressRequest) ConvertToJavaBean.convertToJavaBean(respXml,
                    SfExpressRequest.class);
            if (result == null) {
                String reqXml = requestXml("callExpressRequest/9.responseERR.txt");
                responseXml(reqXml, response);
            }
            // 3. 执行业务逻辑操作
            String remark = result.getBody().getWaybillRoute().getOpCode();
            if (remark.equals("50")) {
                PretTransPlanBo bo = new PretTransPlanBo();
                List<PretTransOrder> pretTransOrderList = pretTransOrderRepository.findByMailno(result.getBody().getWaybillRoute().getMailno());
                List<String> pickUpList = new ArrayList<>();
                String ids = StringUtils.EMPTY;
                for (PretTransOrder pretTransOrder : pretTransOrderList) {
                    ids += pretTransOrder.getId() + ",";
                    if (!pickUpList.contains(pretTransOrder.getPickUpPlanId())) {
                        pickUpList.add(pretTransOrder.getPickUpPlanId());
                    }
                }
                bo.setPickUpIds(Joiner.on(",").join(pickUpList));
                pretTransPlanService.pretTransPlanAdd(bo, true);
            } else if (remark.equals("80")) {
                PretTransPlan pretTransPlan = pretTransPlanRepository.findByMailno(result.getBody().getWaybillRoute().getMailno());
                PretTransPlanSignBo bo = new PretTransPlanSignBo();
                try {
                    bo.setHasException(false);
                    bo.setId(pretTransPlan.getId());
                    bo.setSignDatetime(new Date());
                    pretTransPlanService.sign(bo);
                } catch (FebsException e) {
                    e.printStackTrace();
                }
            } else {
                PretTransPlan pretTransPlan = pretTransPlanRepository.findByMailno(result.getBody().getWaybillRoute().getMailno());

                PretVender pretVender = pretVenderRepository.findById(pretTransPlan.getVenderId()).get();

                PretTransRecord pretTransRecord = new PretTransRecord();

                pretTransRecord.setDescription(result.getBody().getWaybillRoute().getAcceptTime() + result.getBody().getWaybillRoute().getAcceptAddress() + result.getBody().getWaybillRoute().getRemark());
                pretTransRecord.setTransPlanId(pretTransPlan.getId());
                pretTransRecord.setType(ConstantEnum.ETransOrderStatisticsUserType.顺丰.getLabel());
                pretTransRecord.setUsername(pretVender.getName());

                pretTransRecordRepository.save(pretTransRecord);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            String reqXml = requestXml("callExpressRequest/9.responseERR.txt");
            responseXml(reqXml, response);
        }
        String reqXml = requestXml("callExpressRequest/8.responseOK.txt");
        //顺丰丰桥调用路由推送接口，返回响应报文给对方
        responseXml(reqXml, response);
    }

    private String requestXml(String str) {
        String reqXml = "";
        try {
            InputStream in = ApiController.class.getClassLoader().getResourceAsStream(str);
            reqXml = FileStringUtil.readFileByIn(in).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reqXml;
    }

    private void responseXml(String returnResponse, HttpServletResponse response) {
        try {
            response.setContentType("text/xml; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write(returnResponse);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
