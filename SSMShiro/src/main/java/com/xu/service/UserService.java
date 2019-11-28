package com.xu.service;

import com.xu.domain.User;
import com.xu.util.DataGridView;
import com.xu.vo.UserVo;

public interface UserService {

    DataGridView queryAllUser(UserVo userVo);

    User queryUserByUserName(String username);
}
