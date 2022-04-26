package com.atguigu.boot.config;

import com.atguigu.boot.interceptor.LoginInterceptor;
import com.atguigu.boot.interceptor.RedisUrlCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname AdminWebConfig
 * @Description TODO
 * @Date 16:54 2021/9/15
 * @Created by hejx
 *
 *  @EnableWebMvc:全面接管SpringMVC
 *    1、静态资源、视图解析器、欢迎页....全部失效
 *
 *  Filter、Interceptor 几乎拥有相同的功能？
 *  1.Filter是servlet定义的原生组件。好处，脱离Spring应用也能使用
 *  2.Interceptor是Spring定义的接口。可以使用Spring的自动装配
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig  implements WebMvcConfigurer {


    @Autowired
    RedisUrlCount redisUrlCount;


    /**
     * 访问 /aa/** 所有请求都会去 classpath:/static/ 下面进行匹配
     *
     * @param registry
     */
  /*  @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/aa/**")
                .addResourceLocations("classpath:/static/");
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                //放行静态资源
                .excludePathPatterns("/css/**","/fonts/**","/images/**","/js/**")
                //放行登录页面
                .excludePathPatterns("/login","/");

        registry.addInterceptor(redisUrlCount)
                //放行静态资源
                .excludePathPatterns("/css/**","/fonts/**","/images/**","/js/**")
                //放行登录页面
                .excludePathPatterns("/login","/");
    }
}
