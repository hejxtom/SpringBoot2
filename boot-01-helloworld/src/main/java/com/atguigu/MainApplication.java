package com.atguigu;

import ch.qos.logback.classic.db.DBHelper;
import com.atguigu.bean.Pet;
import com.atguigu.bean.User;
import com.atguigu.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类；主配置类
 *  @SpringBootApplication: 这是一个Springboot应用
 *
 *
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //打印出注册的所有组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String name: beanDefinitionNames) {
//            System.out.println(name);
//        }

        //从容器获取组件
        Pet tomcat = run.getBean("tomcat", Pet.class);
        System.out.println(tomcat);

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user==user1);//true


        User user01 = run.getBean("user01", User.class);
        Pet tomcat01=run.getBean("tomcat",Pet.class);
        System.out.println(user01.getPet()==tomcat01);

        System.out.println("******************");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);

        for (String str: beanNamesForType) {
            System.out.println(str);
        }
        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

//        boolean tomcat = run.containsBean("tomcat");
//        System.out.println("是否存在tomcat组件-->"+tomcat);
//
//        boolean user01 = run.containsBean("user01");
//        System.out.println("是否存在user01组件-->"+user01);

    }

}
