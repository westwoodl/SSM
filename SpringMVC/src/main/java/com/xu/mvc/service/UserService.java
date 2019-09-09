package com.xu.mvc.service;

import com.xu.mvc.dao.UserDao;
import com.xu.mvc.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application*.xml")
@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Test
    public void test(){
        System.out.println(dao.getUserById(1));
    }

    public User findUser(Integer id){
        return dao.getUserById(id);
    }
}
