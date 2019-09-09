package com.xu.spring.day02;

import com.xu.spring.day02.dao.UserDao;
import com.xu.spring.day02.service.CustomerService;
import com.xu.spring.day02.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1.ioc注解：@Component
 * 2.di注解：a.普通属性 @Value b.对象类型 @Autowire 按类型注入  @Resource 按名称注入
 * 3.lifeCycle和scope 的注解
 *
 * xml 和 注解的适用场景，和优点：
 *     xml : 任意场景，结构清晰（开发不方便）
 *     注解：适用于自己写的类，开发方便（结构不清晰）
 *
 *     XML和注解整合开发：
 *         xml管理bean， 注解管理属性注入
 *         * 整合开发中可以不用包扫描，因为类都在xml中已经注入到bean了
 *           使用<context:annotation-config/>开启注解
 */
public class SpringDemo1 {
    private ApplicationContext ac;

    @Before
    public void init(){
        ac = new ClassPathXmlApplicationContext("day02/applicationDemo1.xml");
    }

    @Test
    public void test1(){
        ac.getBean("userDao", UserDao.class).save();
    }

    @Test
    public void test2(){
        ac.getBean("userService", UserService.class).save();
    }


    @Test
    public void test3(){
        System.out.println("---");
        ac.getBean("customerService", CustomerService.class).save();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
