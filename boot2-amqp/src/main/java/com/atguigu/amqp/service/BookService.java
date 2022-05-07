package com.atguigu.amqp.service;

import com.atguigu.amqp.beans.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Classname BookService
 * @Description TODO
 * @Date 21:07 2022/5/6
 * @Created by hejx
 */

@Service
public class BookService {

    @RabbitListener(queues = "atguigu")
    public void receive(Book book){
        System.out.println(book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
