package com.web.component;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lijichen
 * @date 2021/1/1 - 16:53
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        } else {
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
    }
}
