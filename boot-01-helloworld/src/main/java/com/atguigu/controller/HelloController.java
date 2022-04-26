package com.atguigu.controller;

import com.atguigu.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 10:13 2021/9/10
 * @Created by hejx
 */
@RestController
public class HelloController {

    @Autowired
    Car car;


    @RequestMapping("/hello")
    public String handl01(String name){
        return "hello,Spring Boot2！你好,name:"+name;
    }


    @RequestMapping("/caar")
    public Car backCar(){
        return car;
    }

}
