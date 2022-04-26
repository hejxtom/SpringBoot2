package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Classname Boss
 * @Description TODO
 * @Date 22:24 2021/9/23
 * @Created by hejx
 */

@Profile("dev")
@Component
@ConfigurationProperties("person")
@Data
public class Boss implements Person{
    private String name;

}
