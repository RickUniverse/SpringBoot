package com.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lijichen
 * @date 2021/1/5 - 14:08
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter..过滤器。。。");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
