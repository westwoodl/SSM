package com.xu.aop.cglib;

public class UserDao {
    private int sum;

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public void update() {
        System.out.println("update");
    }

    public void delete() {
        System.out.println("delete");
    }

    public void save() {
        System.out.println("save");
    }
}
