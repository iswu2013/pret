package com.pret.open.rest;

import com.pret.api.rest.BaseController;
import com.pret.api.vo.ResBody;
import com.pret.open.service.handler.InterfaceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wujinsong
 */
@Controller
@RequestMapping(value = "/rest")
public class ApiController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiController.class);
    // 不需要登录的接口
    public static final Map<String, String> UN_LOGIN_MAP = new HashMap<String, String>();

    static {
        /**
         * 业务用户注册接口
         */
//        UN_LOGIN_MAP.put(InterfaceConfig.HMallGoodsDetail,InterfaceConfig.HMallGoodsDetail);

        UN_LOGIN_MAP.put(InterfaceConfig.H1000000, InterfaceConfig.H1000000);
        UN_LOGIN_MAP.put(InterfaceConfig.H1000004, InterfaceConfig.H1000004);
        UN_LOGIN_MAP.put(InterfaceConfig.H1000006, InterfaceConfig.H1000006);
        UN_LOGIN_MAP.put(InterfaceConfig.H8000005, InterfaceConfig.H8000005);
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public ResBody handle(HttpServletRequest httpServletRequest, String method, String v)
            throws IOException, InterruptedException {
        return this.handle(httpServletRequest, method, v, InterfaceConfig.JOP_VO, InterfaceConfig.JOP_HANDLER, UN_LOGIN_MAP, null);
    }
}
