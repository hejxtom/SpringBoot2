package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Color;
import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 21:55 2021/9/23
 * @Created by hejx
 */

@RestController
public class HelloController {

    @Value("${person.name:lisi}")
    private String name;

    @Autowired
    private Person person;

    @Autowired
    Color color;

    //获取JAVA_HOME
    @Value("${JAVA_HOME}")
    private String msg;

   /* @GetMapping("/")
    public String hello(){
        return  "hello,"+name;
    }*/

 /*   @GetMapping("/")
    public Person hello(){
    return  person;
    }*/

    @GetMapping("/")
    public String hello(){
//        return  "personName:"+person.getName()+",colorName:"+color.getColorName();
        return person.getClass().toString()+",colorName:"+color.getColorName();
    }

    @GetMapping("/msg")
    public String getMsg(){
        return msg;
    }


}
