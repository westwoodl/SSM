package com.xu.mvc.controller;

import com.xu.mvc.dao.UserDao;
import com.xu.mvc.pojo.Item;
import com.xu.mvc.pojo.User;
import com.xu.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring mvc 执行流程
 * 1.http://localhost:8080/mvc/hello.action
 * 2.<url-pattern>*.action</url-pattern>
 * 3.<servlet-class>DispatcherServlet</servlet-class>
 * 4.web中配置的spring配置文件位置
 * 5.application.xml
 * 6.包扫描，controller
 */
@Controller
public class HelloController {


    @RequestMapping("hello")
    public ModelAndView hello(){
        System.out.println("hello springmvc");
        ModelAndView mav = new ModelAndView();

        mav.addObject("msg", "hellospring AAAAAAAA");
        mav.setViewName("hello");

        return mav;
    }

    @RequestMapping("hello2")
    public String hello2(Model model){
        System.out.println("hello springmvc");

        model.addAttribute("msg", "hellospring AAAAAAAA");

        return "hello";
    }

    @RequestMapping("a")
    public ModelAndView a(@RequestParam(value = "id", required = true, defaultValue = "1") Integer id){
        System.out.println("hello springmvc");
        ModelAndView mav = new ModelAndView();

        mav.addObject("msg", "AAAAAAA"+id);
        mav.setViewName("hello");

        return mav;
    }

    @RequestMapping("pojo")
    public ModelAndView pojo( Item item){
        System.out.println("hello springmvc");
        ModelAndView mav = new ModelAndView();

        mav.addObject("msg", "徐荣村"+item.toString());
        mav.setViewName("hello");

        return mav;
    }

    @Autowired
    private UserService service;

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ModelAndView findUser(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView();

        System.out.println("id:"+id);
        mav.addObject("msg", service.findUser(id));
        mav.setViewName("hello");

        return mav;
    }

    //整合mybatis
    @RequestMapping(value = "user2", method = RequestMethod.GET)
    public ModelAndView findUser2(Integer id){
        ModelAndView mav = new ModelAndView();

        System.out.println("id:"+id);
        mav.addObject("msg", service.findUser(id));
        mav.setViewName("hello");

        return mav;
    }

}
