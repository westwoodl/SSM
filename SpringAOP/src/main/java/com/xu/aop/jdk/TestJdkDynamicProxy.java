package com.xu.aop.jdk;

import org.junit.Test;

/**
 * jdk的动态代理只能对实现了接口的类进行代理
 */
public class TestJdkDynamicProxy {

    @Test
    public void test(){
        UserDao dao = new UserDaoImpl();
        dao.save(); // 使用动态代理在save方法执行之前进行权限校验
        dao.update();
        dao.delete();
    }

    @Test
    public void test2(){

        UserDao dao = new JdkProxy(new UserDaoImpl()).creatProxy();
        dao.save();
        System.out.println(dao.getClass());
    }

}
