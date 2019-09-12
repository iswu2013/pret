package com.pret.api.filter.impl;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component()
public class SimpleCORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) res;
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "0");
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token,accessToken,Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("XDomainRequestAllowed", "1");

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }

}
