package com.atguigu.boot.controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname RequstController
 * @Description TODO
 * @Date 14:52 2021/9/12
 * @Created by hejx
 */
@Controller
public class RequstController {

    @GetMapping("/goto")
    public String gotoPage(HttpServletRequest request){
        request.setAttribute("msg","成功了...");
        request.setAttribute("code",200);
        return "forward:/succes";
    }

    @GetMapping("/succes")
    @ResponseBody
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("code") Integer code,
                       HttpServletRequest request){
        Object msg1 = request.getAttribute("msg");
        HashMap<String, Object> map = new HashMap<>();


        map.put("request_msg",msg1);
        map.put("annotation_msg",msg);
        map.put("code",code);
        return map;
    }

    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    @ResponseBody
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand")  List<String> brand,
                                        @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossid}/{empid}")
    @ResponseBody
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossid") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empid") Integer empAge){
        Map<String, Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);

        return map;
    }

}
