package com.atguigu.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Classname MyCacheConfig
 * @Description 测试@Cacheable的keyGenerator属性
 * @Date 16:29 2022/4/30
 * @Created by hejx
 */

@Configuration
public class MyCacheConfig {


    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {

                return method.getName()+"["+ Arrays.asList(params)+"]";
            }
        };
    }

}
