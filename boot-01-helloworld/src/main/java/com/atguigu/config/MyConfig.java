package com.atguigu.config;

import ch.qos.logback.classic.db.DBHelper;
import com.atguigu.bean.Car;
import com.atguigu.bean.Pet;
import com.atguigu.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * @Classname MyConfig
 * @Description TODO
 * @Date 19:11 2021/9/10
 * @Created by hejx
 *
 *@Configuration:
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类也是组件
 * 3、proxyBeanMethods属性:代理bean的方法
 *        true:外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
 * 4、Full模式与Lite模式：
 *  Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *  Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *
 *
 *
 * @Import:(需要导入类的无参构造器生成Bean)
 *     给容器中自动创建出这两个类型的组件
 */

@Import({User.class, DBHelper.class}) // 给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
@Configuration(proxyBeanMethods = false)//告诉SpringBoot这是一个配置类 == 配置文件
//@ImportResource("classpath:beans.xml")//导入spring配置文件使其生效置类===配置文件
/*
* EnableConfigurationProperties:
*       1.开启Car属性配置绑定功能
*       2.把这个Car这个组件自动注册到容器中
*/
@EnableConfigurationProperties(Car.class)
public class MyConfig {

//    @ConditionalOnBean(name="tom")  //容器中有tom，则添加组件到容器
    @ConditionalOnMissingBean(name = "tom") //容器中没有tom，则添加组件到容器
    @Bean//给容器中添加组件。以方法名在作为组件的id。返回类型就是组件类型。返回值，就是组件在容器中的实例
    public User user01(){
        //user组件依赖Pet组件
        return new User("张三",18,tomcat());
    }

    @Bean
    public Pet tomcat(){
        return new Pet("tom");
    }
}
