package com.atguigu.boot.controller;

import com.atguigu.boot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Classname IndexController
 * @Description TODO
 * @Date 20:45 2021/9/13
 * @Created by hejx
 */
@Controller
public class IndexController {


    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account_tbl", Integer.class);
        return integer.toString();
    }


    /**
     * 来登录页
     * @return
     */
    @GetMapping({"/","/login"})
    public String loginPage(){
        return "login";
    }


    //解决表单重复提交
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUsername()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "redirect:/login";
        }
    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");

        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "redirect:/login";
        }
    }

}
