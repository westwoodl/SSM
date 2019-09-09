package com.xu.spring.day02.service;

import com.xu.spring.day02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Autowired private UserDao dao;

    @Resource(name = "userDao")
    private UserDao dao2;

    @Autowired
    @Qualifier(value = "userDao")
    private UserDao dao3;



    public void save(){
        System.out.print("service: ");
        dao.save();
    }
}
