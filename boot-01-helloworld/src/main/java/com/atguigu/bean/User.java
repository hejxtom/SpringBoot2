package com.atguigu.bean;

import lombok.*;

/**
 * 用户
 */
@Data //get/set
@ToString
@AllArgsConstructor //全参构造器
@NoArgsConstructor //无参构造器
public class User {

    private String name;
    private Integer age;
    private Pet pet;
}
