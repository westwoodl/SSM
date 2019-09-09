package com.xu.mybatis.dao;

import com.xu.mybatis.pojo.Order;
import com.xu.mybatis.pojo.User;

import java.util.List;

public interface OrderDao {
    Order getOrderById(Integer id);

    List<Order> getOrderUser();

    List<User> getUserOrderWithResultMap();
}
