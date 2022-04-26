package com.atguigu.boot.controllor;

import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname ParameterTestController
 * @Description TODO
 * @Date 14:10 2021/9/12
 * @Created by hejx
 */
@RestController
public class ParameterTestController {

    // /car/3/owner/lisi?age=18&inters=篮球&inters=游戏
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer  age,
                                     @RequestParam("inters")List<String> inters){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("header",header);
        map.put("age",age);
        map.put("inters",inters);
        return map;
    }


    @PostMapping("/save")
    public Map postMethod(@RequestBody String context){
        Map<String, Object> map = new HashMap<>();

        map.put("context",context);
        return map;
    }

    //需要开启 WebConfig::webMvcConfigurer(),且不允许加@RequestBody
    @PostMapping("/saveuser")
    public Person saveUser( Person person){
        return person;
    }

}
