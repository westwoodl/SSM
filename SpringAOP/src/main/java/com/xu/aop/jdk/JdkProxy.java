package com.xu.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private UserDao dao;

    public JdkProxy(UserDao dao){
        this.dao = dao;
    }

    public UserDao creatProxy(){
        UserDao daoProxy =
                (UserDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                        dao.getClass().getInterfaces(), this);
        return daoProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("save".equals(method.getName()))
            System.out.println("权限校验");
        return method.invoke(dao, args);
    }
}
