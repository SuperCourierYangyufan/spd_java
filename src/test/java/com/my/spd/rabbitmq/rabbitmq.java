package com.my.spd.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by YangYuFan on 2019/1/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class rabbitmq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void fun2(){
        rabbitTemplate.convertAndSend("Spd1v1","test1","nihao");
    }


    @RabbitListener(queues = {"test1"})
    public void fun3(Message message){
        byte[] body = message.getBody();
        System.out.println(new String(body));
    }
}
