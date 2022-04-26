package com.atguigu.boot.mapper;

import com.atguigu.boot.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * BaseMapper<User>:泛型中的User必不可少
 */
//@Repository
public interface UserMapper extends BaseMapper<User> {


}
