package com.xu.service.impl;

import com.xu.dao.UserMapper;
import com.xu.domain.User;
import com.xu.service.UserService;
import com.xu.util.DataGridView;
import com.xu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public DataGridView queryAllUser(UserVo userVo) {
        List<User> list = userMapper.queryAllUser();
        return new DataGridView((long) list.size(), list);
    }

    @Override
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }
}
