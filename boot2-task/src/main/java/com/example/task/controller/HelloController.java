package com.example.task.controller;

import com.example.task.service.AnynsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 9:49 2022/5/7
 * @Created by hejx
 */
@RestController
public class HelloController {

    @Autowired
    AnynsService anynsService;


    @GetMapping("/hello")
    public String hello(){
        anynsService.hello();
       return "success";
    }

}
