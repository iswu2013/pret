package com.pret.api.filter;

import com.pret.api.vo.ReqBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 过滤器
 *
 * @author wujinsong
 */
public interface JopFilter {

    void doFilter(ReqBody requestBody, HttpServletRequest httpServletRequest, JopFilterChain jopFilterChain);

}
