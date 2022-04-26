package com.atguigu.boot.controllor;

import com.atguigu.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Classname ResponseTestController
 * @Description TODO
 * @Date 10:23 2021/9/20
 * @Created by hejx
 */
@Controller
public class ResponseTestController {


    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(20);
        person.setBirth(new Date());
        person.setUserName("Tom");
        return person;
    }

}
