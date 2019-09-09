package com.xu.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private UserDao dao;

    public CglibProxy(UserDao dao) {
        this.dao = dao;
    }

    public UserDao createProxy(){
        //1.创建cglib核心对象
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(dao.getClass());
        //3.设置回调 （类似于InvokingHandler）
        enhancer.setCallback(this);

        return (UserDao) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if("save".equals(method.getName()))
            System.out.println("proxy!，权限校验");
        return methodProxy.invokeSuper(o, objects);
    }
}
