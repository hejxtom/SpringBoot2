package com.atguigu.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Classname FormTestController
 * @Description TODO
 * @Date 19:09 2021/9/15
 * @Created by hejx
 *
 * 测试文件上传
 *
 */
@Controller
@Slf4j
public class FormTestController {

    @GetMapping("/form_layouts")
    public String formLayouts(){

        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestParam("headerImg") MultipartFile headerImg,
                         @RequestParam("photos") MultipartFile[] photos) throws IOException {

        if(!headerImg.isEmpty()){
            headerImg.transferTo(new File("D:\\44\\"+headerImg.getOriginalFilename()));
        }

        if(photos.length>0){
            for (MultipartFile photo:photos) {
                photo.transferTo(new File("D:\\44\\"+photo.getOriginalFilename()));
            }
        }
        log.info("上传信息：");
        log.info("email："+email);
        log.info("username："+username);
        return "main";
    }


}
