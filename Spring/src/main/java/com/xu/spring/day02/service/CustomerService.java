package com.xu.spring.day02.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <bean id="customerService" class="com.xu.spring.day02.service.CustomerService"
 *     init-method="" destroy-method="" />
 */
@Service
@Scope("prototype")//默认为单利模式
public class CustomerService {
    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }

    public void save(){
        System.out.println("save:" + this);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }
}
