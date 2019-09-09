package com.xu.spring.day01;

import com.xu.spring.day01.service.UserService;
import com.xu.spring.day01.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring IoC使用 工厂模式+反射+配置文件解析
 * 1.id class                {@link #test1TraditionalMethod()}
 * 2.lifeCycle               {@link #test2SpringBasicProperties()}
 * 3.scope                   {@link #test3LifeCycle()}
 * 4.DI of set and construct {@link #test4Ref()}
 */
public class SpringDemo1 {

    /**
     * 1.传统的方式有什么不好的地方：
     *     修改UserService的实现类会修改下面的代码
     */
    @Test
    public void test1TraditionalMethod(){
        UserService service = new UserServiceImpl();
    }

    /**
     * 2.spring 先写配置文件
     */
    @Test
    public void test2SpringBasicProperties(){
        //创建工厂
        /**
         * spring的工厂类：
         *     1.BeanFactory：getBean时创建实例
         *     2.ApplicationContext：加载配置文件时创建实例
         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("day01/applicationDemo1.xml");
        //ApplicationContext a2 = new FileSystemXmlApplicationContext("C:/applicationDemo1.xml");
        UserService service = ac.getBean("userService", UserService.class);
        service.save();
    }

    /**
     * bean的生命周期
     */
    @Test
    public void test3LifeCycle(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("day01/applicationDemo1.xml");
        UserService service = ac.getBean("userService", UserService.class);
        service.save();
        ac.close();//关闭工厂
    }

    /**
     * 依赖注入
     */
    @Test
    public void test4Ref(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("day01/applicationDemo1.xml");

        UserService service = ac.getBean("userService", UserService.class);
        System.out.println(service);
    }
}
