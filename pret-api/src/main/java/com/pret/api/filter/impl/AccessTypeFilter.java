package com.pret.api.filter.impl;

import com.pret.api.vo.ReqBody;
import com.pret.api.filter.JopFilter;
import com.pret.api.filter.JopFilterChain;
import com.pret.common.constant.Constants;
import com.pret.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 访问方式过滤器，读取只能用get，写只能用post
 *
 * @author wujinsong
 */
@Service
public class AccessTypeFilter implements JopFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTypeFilter.class);

    @Override
    public synchronized void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest, JopFilterChain jopFilterChain) {

        String method = httpServletRequest.getMethod();
        if (requestBody.getMethod().indexOf("get") >= 0) {
            if (!method.equals("GET")) {
                LOGGER.warn("访问方式错误");
                throw new BusinessException(Constants.METHOD_ERROR,
                        Constants.S_METHOD_ERROR);
            }

        } else {
            if (!method.equals("POST")) {
                LOGGER.warn("访问方式错误");
                throw new BusinessException(Constants.METHOD_ERROR,
                        Constants.S_METHOD_ERROR);
            }
        }
        jopFilterChain.doFilter(requestBody, httpServletRequest);

    }
}
