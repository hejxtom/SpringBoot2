package com.atguigu.boot.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname ViweTestContrller
 * @Description TODO
 * @Date 16:20 2021/9/13
 * @Created by hejx
 */
@Controller
public class ViweTestContrller {


    @RequestMapping("/atguigu")
    public String atguigu(Model model){
        model.addAttribute("msg","你好，atguigu");
        model.addAttribute("link","www.baidu.com");
        return "success";
    }

}
