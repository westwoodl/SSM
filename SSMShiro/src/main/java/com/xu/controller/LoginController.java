package com.xu.controller;

import com.xu.util.ActiveUser;
import com.xu.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {


    @RequestMapping("toLogin")
    public String toLogin(HttpServletRequest request){

        return request.getContextPath() + "/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping("login")
    public String login(UserVo userVo, HttpSession session, HttpServletRequest request){
        UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getUserpwd());

        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
            session.setAttribute("user", activeUser.getUser());
            return request.getContextPath() + "/WEB-INF/jsp/list.jsp";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
            request.setAttribute("login" , "密码不正确");
        } catch (UnknownAccountException e) {
            System.out.println("账号不存在");
            request.setAttribute("login" , "账号不存在");
        }
        return request.getContextPath() + "/WEB-INF/jsp/login.jsp";
    }
}
