package com.atguigu.boot;

import com.atguigu.boot.mapper.UserMapper;
import com.atguigu.boot.service.UserService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootTest
@Slf4j
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource source;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisConnectionFactory connectionFactory;

    @Test
    void contextLoads() {
    }

    @Test
    void conextLoads(){
        Integer integer = jdbcTemplate.queryForObject("select count(*) from account_tbl", Integer.class);
        System.out.println(integer);

        log.info("数据类型：{}",source.getClass());
        log.info("数据类型：{}",jdbcTemplate.getClass());
    }


    @Test
    void testUserMapper(){
//        Object byId = userMapper.selectById(1);
//        log.info("用户信息：{}",byId);

        userService.removeById(1);

    }

    @Test
    void testRedis(){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set("hello","world");

        String hello = operations.get("hello");
        System.out.println(hello);

        System.out.println(redisTemplate.getClass());

    }
}
