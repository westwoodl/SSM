package com.xu.mybatis;

import com.xu.mybatis.dao.UserDao;
import com.xu.mybatis.pojo.User;
import com.xu.mybatis.util.SqlSessionFactoryUtil;
import org.junit.Test;

import java.io.IOException;

public class t03DaoTest {

    @Test
    public void test() throws IOException {
        UserDao userDao = SqlSessionFactoryUtil.getInstance().openSession().getMapper(UserDao.class);
        User user = userDao.getUserById(30);
        System.out.println(user);
    }
}
