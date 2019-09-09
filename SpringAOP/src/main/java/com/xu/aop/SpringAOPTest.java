package com.xu.aop;

import com.xu.aop.aop.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * AOP xml的使用方式
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class SpringAOPTest {
    @Resource
    private UserDao userDao;

    @Test
    public void test(){
        userDao.save();
        userDao.delete();

        userDao.update();

        userDao.find();
    }
}
