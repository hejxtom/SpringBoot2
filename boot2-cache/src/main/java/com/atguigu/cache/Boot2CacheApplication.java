package com.atguigu.cache;

import org.apache.ibatis.type.Alias;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.cache.mapper")
public class Boot2CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot2CacheApplication.class, args);
    }

}
