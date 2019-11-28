package com.xu.controller;

import com.xu.service.UserService;
import com.xu.util.DataGridView;
import com.xu.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user/query")
    @ResponseBody
    private DataGridView queryUser(UserVo userVo) {
        return userService.queryAllUser(userVo);
    }

}
