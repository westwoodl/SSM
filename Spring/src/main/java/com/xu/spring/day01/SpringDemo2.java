package com.xu.spring.day01;

import com.xu.spring.day01.domain.Collection;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
    /**
     * p namespace and SpEL
     */
    @Test
    public void test(){

    }

    @Test
    public void test2(){
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("day01/applicationDemo2.xml");
        System.out.println(ac.getBean("collection", Collection.class));
    }
}
