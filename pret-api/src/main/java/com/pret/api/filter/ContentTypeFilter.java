package com.pret.api.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component()
public class ContentTypeFilter implements Filter {
    private String charset = "UTF-8";
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
        String charset = config.getServletContext().getInitParameter("charset");
        if (charset != null && charset.trim().length() != 0) {
            this.charset = charset;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // 设置请求响应字符编码
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);

        HttpServletRequest req = (HttpServletRequest) request;
        // 执行下一个过滤器（如果有的话,否则执行目标servlet）
        chain.doFilter(req, response);
    }

    @Override
    public void destroy() {
        System.out.println(config.getFilterName() + "被销毁");
        charset = null;
        config = null;
    }

}
