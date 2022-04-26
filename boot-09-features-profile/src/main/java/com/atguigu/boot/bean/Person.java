package com.atguigu.boot.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Classname Person
 * @Description TODO
 * @Date 22:13 2021/9/23
 * @Created by hejx
 */

//@Component
//@ConfigurationProperties("person")
//@Data
//public class Person {
//    private String name;
//    private Integer age;
//
//}
public interface Person {
    String getName();

}