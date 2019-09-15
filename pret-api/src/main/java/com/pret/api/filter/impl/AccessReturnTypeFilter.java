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
 * 响应格式过滤器；当format不等于json或者xml时，返回错误代码100105
 *
 * @author wujinsong
 */
@Service
public class AccessReturnTypeFilter implements JopFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessReturnTypeFilter.class);

    @Override
    public synchronized void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest,
                                      JopFilterChain jopFilterChain) {
        // 获取响应格式
        String format = requestBody.getFormat();
        /*
         * format不为json或xml时，返回错误代码100105
         */
        if (!"json".equals(format) && !"xml".equals(format)) {
            LOGGER.warn("响应格式错误");
            throw new BusinessException(Constants.BUSI_ERROR_000008, Constants.S_BUSI_ERROR_000008);
        }
        jopFilterChain.doFilter(requestBody, httpServletRequest);
    }
}
