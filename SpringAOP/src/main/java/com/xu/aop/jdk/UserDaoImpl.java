package com.xu.aop.jdk;

public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void save() {
        System.out.println("save");
    }
}
