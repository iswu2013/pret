package com.pret.api.filter;

import com.pret.api.vo.ReqBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器链
 *
 * @author wujinsong
 */
public interface JopFilterChain {

    /**
     * @param requestBody
     * @param httpServletRequest
     * @return
     */
    public ReqBody doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest);

}
