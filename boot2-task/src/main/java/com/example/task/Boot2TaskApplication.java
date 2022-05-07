package com.example.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @EnableAsync+@Async：异步处理
 * @EnableScheduling+@Scheduled：定时任务
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Boot2TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot2TaskApplication.class, args);
    }

}
