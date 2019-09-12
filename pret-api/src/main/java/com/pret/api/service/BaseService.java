package com.pret.api.service;

import com.pret.api.filter.JopFilterChain;
import com.pret.api.vo.ReqBody;
import com.pret.api.vo.ResBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


@Service
public class BaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseManageService.class);
    @Autowired
    private JopFilterChain jopFilterChain;

    public ResBody handle(HttpServletRequest httpServletRequest, ReqBody reqBody)
            throws IOException, InterruptedException {

        LOGGER.info(httpServletRequest.getMethod());
        LOGGER.info(getParameters(httpServletRequest));
        // 过滤
        reqBody = jopFilterChain.doFilter(reqBody, httpServletRequest);
        ResBody responseBody = null;
        responseBody = executeTask(httpServletRequest, reqBody);

        return responseBody;
    }

    /**
     * @param httpServletRequest
     * @param requestBody
     * @return
     * @description: 执行任务
     * @author: wujinsong
     */
    private synchronized ResBody executeTask(HttpServletRequest httpServletRequest, ReqBody requestBody) {
        ResBody responseBody;
        String version = requestBody.getV().trim();
        requestBody.setHttpRequest(httpServletRequest);
        responseBody = requestBody.getHandler().handle(requestBody);
        LOGGER.debug("接口调用成功,接口版本【" + version + "】");
        return responseBody;
    }

    public String getParameters(HttpServletRequest httpServletRequest) {
        Map<String, String[]> params = httpServletRequest.getParameterMap();
        String queryString = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                queryString += key + "=" + value + "&";
            }
        }
        // 去掉最后一个空格
        int length = queryString.length();
        if (length > 0) {
            return queryString.substring(0, length - 1);
        }
        return queryString;
    }
}
