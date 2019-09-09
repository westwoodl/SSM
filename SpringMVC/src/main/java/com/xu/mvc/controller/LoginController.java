package com.xu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(String user, HttpServletRequest request, Model model){
        request.getSession().setAttribute("user", user);
        System.out.println(request.getSession().getAttribute("user"));
        model.addAttribute("msg", new Date()+""+request.getSession().getAttribute("user"));
        return "hello";
    }
}
