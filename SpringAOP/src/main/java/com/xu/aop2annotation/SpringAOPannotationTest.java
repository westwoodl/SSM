package com.xu.aop2annotation;

import com.xu.aop2annotation.aop.OrderDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application2.xml")
public class SpringAOPannotationTest {
    private OrderDao dao;

    @Resource
    public void setDao(OrderDao dao) {
        this.dao = dao;
    }

    @Test
    public void test(){
        dao.save();
        dao.delete();
        dao.update();
        dao.find();
    }
}
