package com.atguigu.boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * @Classname Person
 * @Description TODO
 * @Date 17:04 2021/9/18
 * @Created by hejx
 */
@Data
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;

}
