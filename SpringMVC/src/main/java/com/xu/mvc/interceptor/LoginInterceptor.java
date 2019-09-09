package com.xu.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override//进入方法前执行：登录拦截，权限校验
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String session = (String) request.getSession().getAttribute("user");
        System.out.println(session);
        if(request.getSession().getAttribute("user")==null&&"".equals(session)) {
            response.sendRedirect("login.jsp");
            return false;
        }
        return true;
    }

    @Override//进入方法后，返回ModelAndView之前：设置页面参数
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//方法执行之后：关闭资源，记录日志
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("loginsuccess:登陆成功");
    }
}
