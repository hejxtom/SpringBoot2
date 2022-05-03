package com.atguigu.cache;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Boot2CacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    RedisTemplate redisTemplate; //k-v都是对象的


    @Autowired
    StringRedisTemplate stringRedisTemplate; //操作k-v都是字符串的

    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;

    @Test
    void contextLoads() {
//        employeeMapper.getEmpById(1);
//        employeeMapper.updateEmp(new Employee(1,"hejx","2222@test.com",null,null));

        employeeMapper.getEmpByLastName("h");
    }

    /**
     * Redis常见的五大数据类型
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     * stringRedisTemplate.opsForValue()[String（字符串）]
     * stringRedisTemplate.opsForList()[List（列表）]
     * stringRedisTemplate.opsForSet()[Set（集合）]
     * stringRedisTemplate.opsForHash()[Hash（散列）]
     * stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */

//    测试保存对象到Redis
    @Test
    void testRedis() {
        Employee emp = employeeMapper.getEmpById(1);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据保存到redis中
//        redisTemplate.opsForValue().set("emp",emp);

        //1、将数据以json的方式保存
        //(1)自己将对象转为json
        //(2)redisTemplate默认的序列化规则；改变默认的序列化规则；此时empRedisTemplate是自定义的
        empRedisTemplate.opsForValue().set("emp1", emp);
    }

}
