package com.pret.api.rest;

import com.pret.api.filter.BaseContext;
import com.pret.api.handler.JopHandler;
import com.pret.api.service.BaseService;
import com.pret.api.session.UserContext;
import com.pret.api.vo.ErrorResponseBody;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujinsong
 */
public class BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseManageController.class);
    // 不需要登录的接口
    public static final Map<String, String> UN_LOGIN_MAP = new HashMap<String, String>();

    @Autowired
    private Map<String, JopHandler> jopHandlers;

    @Autowired
    private BaseService baseService;
    @Autowired
    protected BaseContext baseContext;

    private static List<String> filterError = Arrays
            .asList(new String[]{Constants.PARAM_ERROR, Constants.METHOD_ERROR});

    public ResBody handle(HttpServletRequest httpServletRequest, String method, String v, Map<String, Class<? extends ReqBody>> reqMap, Map<String, String> handlerMap, Map<String, String> unLoginMap, Map<String, String> unBodyMap)
            throws IOException, InterruptedException {
        ReqBody requestBody = new ReqBody();
        requestBody.setMethod(method);
        requestBody.setV(v);
        requestBody.setHttpRequest(httpServletRequest);
        if (!unLoginMap.containsKey(requestBody.getMethod())) {
            requestBody.setIgnoreToken(false);
        }

        if(unBodyMap != null) {
            if(unBodyMap.containsKey(requestBody.getMethod())) {
                requestBody.setIgnoreBody(true);
            }
        }

        requestBody.setReqBody(reqMap.get(method));
        requestBody.setHandler(jopHandlers.get(handlerMap.get(method)));
        ResBody resBody = baseService.handle(httpServletRequest, requestBody);
        return resBody;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResBody handleIOException(BusinessException e) {
        LOGGER.warn(e.getMessage(), e);
        ErrorResponseBody responseBody = ErrorResponseBody.createErrorResponseBody(e.getCode(), e.getMessage());
        return responseBody;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResBody handleIOException(Exception e) {
        LOGGER.error("调用接口失败", e);
        ErrorResponseBody responseBody = ErrorResponseBody.createErrorResponseBody(Constants.SYSTEM_ERROR,
                Constants.S_SYSTEM_ERROR);
        UserContext.remove();
        return responseBody;
    }
}
