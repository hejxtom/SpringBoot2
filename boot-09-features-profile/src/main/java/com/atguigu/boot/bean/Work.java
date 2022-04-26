package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Classname Work
 * @Description TODO
 * @Date 22:25 2021/9/23
 * @Created by hejx
 */

@Profile("prod")
@Component
@ConfigurationProperties("person")
@Data
public class Work implements Person{
    private String name;
}
