package com.vistula.chatboxrabbitmqconsument;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/receiveMessage")
    public Object get() {
        Object message = rabbitTemplate.receiveAndConvert( "kolejka");
        return message;
    }

    @RabbitListener(queues = "kolejka")
    public void get(String s) {
        System.out.println(s);
    }
}
