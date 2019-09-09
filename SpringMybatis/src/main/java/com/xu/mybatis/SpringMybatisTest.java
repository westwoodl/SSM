package com.xu.mybatis;

import com.xu.mybatis.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application01.xml")
public class SpringMybatisTest {
//    @Resource(name = "userDaoImpl") UserDaoImpl userDao;
//
//    @Test
//    public void test01(){
//        System.out.println(userDao.getUserById(1));
//    }

    @Resource private UserDao userDao;
    @Test
    public void test(){
        System.out.println(userDao.getUserById(1));
    }
}
