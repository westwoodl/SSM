package com.xu.mybatis;

import com.xu.mybatis.dao.OrderDao;
import com.xu.mybatis.dao.UserDao;
import com.xu.mybatis.pojo.Order;
import com.xu.mybatis.pojo.QueryVo;
import com.xu.mybatis.pojo.User;
import com.xu.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * 第二天
 */
public class t04Day02Test {
    private SqlSession sqlSession;
    @Before
    public void init() throws IOException {sqlSession = SqlSessionFactoryUtil.getInstance().openSession();}
    /**
     * 1.使用包装类查询
     */
    @Test
    public void test() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getInstance().openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("张");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        System.out.println(userDao.getUserByQueryVo(queryVo));
    }

    /**
     * 2.mapper配置文件的ResultMap的使用
     */
    @Test
    public void testResultMap() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getInstance().openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        System.out.println(orderDao.getOrderById(3));
    }
    /**
     * 3.<if></if>和<where></where>标签的使用
     */
    @Test
    public void testIfWhere() throws IOException {
        SqlSession sqlSession = SqlSessionFactoryUtil.getInstance().openSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        System.out.println(orderDao.getOrderById(null));
    }

    /**
     * 4.使用ResultMap完成一对一关联查询
     */
    @Test
    public void testResultMap2(){
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        for (Order o : orderDao.getOrderUser())
            System.out.println(o);
    }

    /**
     * 5.使用ResultMap完成一对多关联查询
     */
    @Test
    public void testResultMap3(){
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        for (User o : orderDao.getUserOrderWithResultMap()) {
            System.out.print(o);
            System.out.println(o.getOrderList());
        }
    }
}
