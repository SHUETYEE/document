package com.itheima.document.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李靖宇
 * @Project document
 * @date 2020/1/6 15:26
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/");
            return false;
        }
        return true;
    }
}
