package com.xu.spring.day02.dao.impl;

import com.xu.spring.day02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

//@Repository(value = "userDao")
@Repository("userDao")
//相当于在配置文件中配置：<bean id="userDao" class="com.xu.spring.day02.dao.impl.UserDaoImpl" />
public class UserDaoImpl implements UserDao {

    @Value("没有set方法")
    private String name;


    @Value("姓名")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void save() {
        System.out.println("dao: 保存"+name);
    }
}
