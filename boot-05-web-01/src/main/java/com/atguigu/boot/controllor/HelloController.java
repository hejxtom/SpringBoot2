package com.atguigu.boot.controllor;

import org.springframework.web.bind.annotation.*;

/**
 * @Classname HelloController
 * @Description TODO
 * @Date 22:34 2021/9/11
 * @Created by hejx
 */
@RestController
public class HelloController {

    @RequestMapping("/bug.jpg")
    public String get() {
        return "aaa";
    }


//    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser() {

        return "GET-张三";
    }

//    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser() {
        return "POST-张三";
    }


//    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser() {

        return "PUT-张三";
    }

        @DeleteMapping("/user")
//    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE-张三";
    }

    //扩展点：如何把 _method 这个名字换成我们自己喜欢的
    //在配置类WebConfig中注册一个HiddenHttpMethodFilter的bean

}
