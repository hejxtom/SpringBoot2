package com.atguigu.bean;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * *只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@Data
@ToString
//@Component//只有在容器中的组件，才会拥有SpringBoot提供的强大功能
@ConfigurationProperties(prefix = "car")
public class Car {

    private String brand;
    private Integer price;

}
