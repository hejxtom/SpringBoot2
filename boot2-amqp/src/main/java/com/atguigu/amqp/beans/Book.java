package com.atguigu.amqp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Book
 * @Description TODO
 * @Date 9:56 2022/5/6
 * @Created by hejx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer bId;
    private String bName;

}
