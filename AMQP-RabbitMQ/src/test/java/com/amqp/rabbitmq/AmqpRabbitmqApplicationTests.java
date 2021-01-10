package com.amqp.rabbitmq;

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
class AmqpRabbitmqApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    void create() {
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));

        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,
                "amqpadmin.exchange","amqpadmin.routingkey",null));
    }

    /**
     * 一对一单点发送
     */
    @Test
    void sendDirect() {
        Map<Object,Object> map = new HashMap<>();
        map.put("msg","这是一条消息");
        map.put("data", Arrays.asList("qqqq",true,1,null));
        rabbitTemplate.convertAndSend("prefix.suffix","prefix.suffix",map);
        // "prefix.suffix"  exchange起名一开始起错了
    }

    @Test//接受消息
    void receive() {
        Object o = rabbitTemplate.receiveAndConvert("prefix.suffix");
        System.out.println(o.getClass());
        System.out.println(o);
    }

}
