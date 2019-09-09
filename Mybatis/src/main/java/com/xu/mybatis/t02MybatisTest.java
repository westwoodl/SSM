package com.xu.mybatis;

import com.xu.mybatis.pojo.User;
import com.xu.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class t02MybatisTest {
    private SqlSession ss;
    @Before
    public void init() throws IOException {
        //加载mybatis配置文件
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("SqlMapperConfig.xml");

        SqlSessionFactory ssf = ssfb.build(is);

        ss = ssf.openSession();
    }

    @Test
    public void test() throws IOException {


        User user = ss.selectOne("user.getUserById", 1);
        System.out.println(user);

        List<User> users = ss.selectList("user.getUserByName", "张");
        System.out.println(users);

        User insert_user = new User();
        insert_user.setUsername("杨2");
        insert_user.setBirthday(new Date());
        ss.insert("user.insertUser", insert_user);
        System.out.println(insert_user);
        ss.commit();//mybatis事务默认不自动提交

    }

    @Test
    public void test2() throws IOException {
        System.out.println(SqlSessionFactoryUtil.getInstance());
        System.out.println(SqlSessionFactoryUtil.getInstance());
    }

    @After
    public void destory(){
        if(ss!=null) ss.close();
    }
}
