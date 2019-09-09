package com.xu.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class MyInterceptor01 implements HandlerInterceptor {
    @Override//进入方法前执行：登录拦截，权限校验
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1pre");
        return true;
    }

    @Override//进入方法后，返回ModelAndView之前：设置页面参数
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("1post");
    }

    @Override//方法执行之后：关闭资源，记录日志
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("1after");
    }
}
