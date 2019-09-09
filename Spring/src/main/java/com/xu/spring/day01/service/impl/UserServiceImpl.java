package com.xu.spring.day01.service.impl;

import com.xu.spring.day01.domain.User;
import com.xu.spring.day01.service.UserService;

public class UserServiceImpl implements UserService {
    private String name;
    private Integer age;
    private User user;


    public UserServiceImpl(){

    }

    public UserServiceImpl(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void save(){
        System.out.println("UserServiceImpl:"+name);
    }
    /**
     * bean的生命周期
     */
    public void init(){
        System.out.println("init");
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", user=" + user +
                '}';
    }

    public void destory(){
        System.out.println("destory");
    }
}
