package com.xu.mybatis.dao;

import com.xu.mybatis.pojo.QueryVo;
import com.xu.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    User getUserById(int id);
    User getUserByName(String name);
    void insertUser(User user);
    void updateUser(User user);
    void deleteById(int id);

    List<User> getUserByQueryVo(QueryVo queryVo);
}
