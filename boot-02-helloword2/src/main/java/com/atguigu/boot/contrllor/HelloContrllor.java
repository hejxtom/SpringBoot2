package com.atguigu.boot.contrllor;

import com.atguigu.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HelloContrllor
 * @Description TODO
 * @Date 16:36 2021/9/11
 * @Created by hejx
 */
@RestController
public class HelloContrllor {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person getPerson(){
        return person;
    }

}
