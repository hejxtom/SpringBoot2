package com.atguigu.boot.service.impl;

import com.atguigu.boot.bean.User;
import com.atguigu.boot.mapper.UserMapper;
import com.atguigu.boot.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 17:24 2021/9/22
 * @Created by hejx
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
