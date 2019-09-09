package com.xu.mvc;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器：配个bean，完成
 */
public class MVCResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ModelAndView mav = new ModelAndView();

        ex.printStackTrace();
        mav.addObject("msg", "发生异常！</br>报错信息：<br>"+ex);
        mav.setViewName("hello");

        return mav;
    }
}
