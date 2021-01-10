package com.amqp.rabbitmq.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2021/1/9 - 16:20
 */
@Service
public class MessageService {

    @RabbitListeners(value = {
            @RabbitListener(queues = "prefix.suffix")//指定接受那个队列中的消息
    })
    public void rabbitMQListener(Message message) {
        System.out.println(message.getBody());//消息内容
        System.out.println(message.getMessageProperties());//消息的其他  信息
    }
}
