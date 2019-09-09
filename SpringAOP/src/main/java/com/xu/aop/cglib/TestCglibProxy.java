package com.xu.aop.cglib;

import org.junit.Test;

public class TestCglibProxy {

    @Test
    public void test(){
        CglibProxy cglib = new CglibProxy(new UserDao());
        cglib.createProxy().save();
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        dao.setSum(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100000;i++)
                    dao.setSum(dao.getSum()+i);
            }
        }).run();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i<100000;i++)
                    dao.setSum(dao.getSum()+i);
            }
        }).run();

        System.out.println(dao.getSum());
    }
}
