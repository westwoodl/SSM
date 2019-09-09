package com.xu.mvc.controller;

import com.xu.mvc.pojo.Item;
import com.xu.mvc.pojo.QueryItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class HelloDay02 {

    //传入数组
    @RequestMapping("array")//uri = array?id=1&id=2 或者 id=1,2
    public String bat(Model model, Integer... id) {
        model.addAttribute("msg", Arrays.toString(id));
        return "hello";
    }


    //传入list 必须加一个@RequestParam("list")
    @RequestMapping("list")//uri = array?id=1&id=2 或者 id=1,2
    public String bat2(Model model, @RequestParam("id") ArrayList<String> id) {
        System.out.println(id);
        model.addAttribute("msg", id.toString());
        return "hello";
    }

    //包装类里包含list
    @RequestMapping("items")//uri = array?id=1&id=2 或者 id=1,2
    public String bat3(Model model, @RequestParam("item") QueryItems qi) {
        System.out.println(qi);
        model.addAttribute("msg", qi.toString());
        return "hello";
    }

    @RequestMapping("error")
    public String error() {
        return 1 / 0 + "";
    }

    //上传图片
    @RequestMapping(value = "upload", method = {RequestMethod.POST, RequestMethod.GET})
    public String updateItem(Item item, Model model, MultipartFile picFile) throws Exception {

        // 图片新名字
        String name = UUID.randomUUID().toString();
        // 图片原名字
        String oldName = picFile.getOriginalFilename();
        // 后缀名
        String exeName = oldName.substring(oldName.lastIndexOf("."));

        File pic = new File("C:\\Users\\RongChao Xu\\Desktop\\" + name + exeName);
        // 保存图片到本地磁盘
        picFile.transferTo(pic);


        model.addAttribute("item", item);
        model.addAttribute("msg", "修改商品成功");
        return "hello";

    }

    //json
    @RequestMapping("getItem")
    @ResponseBody
    public Item getItem(@RequestBody Item item){
        return item;
    }

    @RequestMapping("test")
    @ResponseBody
    public Item getItem(Integer id){
        Item item = new Item();
        item.setId(id);
        item.setName("xuxuxux");
        return item;
    }
}