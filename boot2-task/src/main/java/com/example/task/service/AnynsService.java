package com.example.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Classname AnynsService
 * @Description TODO
 * @Date 9:49 2022/5/7
 * @Created by hejx
 */

@Service
public class AnynsService {

    @Async  //异步处理
    public String hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "hello";
    }

}
