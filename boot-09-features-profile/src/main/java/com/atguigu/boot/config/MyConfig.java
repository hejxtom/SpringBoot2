package com.atguigu.boot.config;

import com.atguigu.boot.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * @Classname MyConfig
 * @Description TODO
 * @Date 22:27 2021/9/23
 * @Created by hejx
 */

@Configuration
public class MyConfig {

    @Profile("prod")
    @Bean
    public Color red(){
        return new Color("red");
    }


    @Profile("dev")
    @Bean
    public Color green(){
        return new Color("green");
    }


}
