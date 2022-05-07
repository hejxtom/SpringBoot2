package com.atguigu.amqp;

import com.atguigu.amqp.beans.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Boot2AmqpApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;


    @Test
    public void testAmqpAdmin(){
//        创建交换器
//        amqpAdmin.declareExchange(new DirectExchange("amqp.exchange"));
//        创建队列
//        amqpAdmin.declareQueue(new Queue("amqp.queue"));
//        绑定
//        String destination, DestinationType destinationType, String exchange, String routingKey, @Nullable Map<String, Object> arguments
        amqpAdmin.declareBinding(new Binding("amqp.queue", Binding.DestinationType.QUEUE,"amqp.exchange","amqp.news",null));

    }


    /**
     * 1、单播（点对点）
     */
    @Test
    void test01() {
        Map<String, Object> map = new HashMap<>();
//        map.put("msg1","hello");
//        map.put("msg2", Arrays.asList(123,"abc",true));
//        自动序列化-->看起来好似'乱码'
//        rabbitTemplate.convertAndSend("exchang3.direct","atguigu",map);
//        如果配置了MessageConverter-->MyAMQPConfig可转成JSON

//        map.put("class1",new Book(1,"红楼梦"));
        rabbitTemplate.convertAndSend("exchang3.direct","atguigu",new Book(1,"红楼梦2"));

    }

    @Test
    void test101(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
