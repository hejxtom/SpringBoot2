package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import com.atguigu.boot.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname TableController
 * @Description TODO
 * @Date 13:32 2021/9/15
 * @Created by hejx
 */
@Controller
public class TableController {

    @Autowired
    UserService userService;


    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,@RequestParam(value = "pn",defaultValue = "1") Integer pn){
//        System.out.println(id);
        boolean b = userService.removeById(id);
//        System.out.println(b);
        return "redirect:/dynamic_table?pn="+pn;
    }

    @GetMapping("/basic_table")
    public String basicTable(){

        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamicTablel(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123456"));
//
//        model.addAttribute("users",users);

        /*List<User> users = userService.list();
        model.addAttribute("users",users);*/

        //必须配置分页插件
        Page<User> userPage = new Page<User>(pn,5);
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);
        page.hasNext();
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsiveTable(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editableTable(){

        return "table/editable_table";
    }

}
