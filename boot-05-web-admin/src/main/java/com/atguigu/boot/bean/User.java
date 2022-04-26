package com.atguigu.boot.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.soap.SAAJResult;
import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 21:12 2021/9/13
 * @Created by hejx
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user")
public class User implements Serializable {
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;


    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
