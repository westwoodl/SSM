package com.xu.aop2annotation.aop;

/**
 * 没有实现接口，aop使用cglib进行动态代理
 */
public class OrderDao {
    public void update() {
        System.out.println("升级订单");
    }

    public String delete() {
        System.out.println("删除订单");
        return "后置通知接收参数";
    }

    public void save() {
        System.out.println("保存订单。。");
    }

    public void find() {
        System.out.println("查询订单。。。");
        throw new RuntimeException("find Exception");
    }
}
