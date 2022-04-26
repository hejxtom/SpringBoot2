package com.atguigu.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class Boot02Helloword2Application {

    public static void main(String[] args) {
        SpringApplication.run(Boot02Helloword2Application.class, args);
    }

}
