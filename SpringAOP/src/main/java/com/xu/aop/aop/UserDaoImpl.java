package com.xu.aop.aop;

public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public String delete() {
        System.out.println("delete");
        return "后置通知接收参数";
    }

    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public void find() {
        System.out.println("find");
        throw new RuntimeException("find Exception");
    }
}
