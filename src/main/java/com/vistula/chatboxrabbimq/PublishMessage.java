package com.vistula.chatboxrabbimq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/add")
    public String get(@RequestParam String message) {
        rabbitTemplate.convertAndSend("kolejka", message);
        return "sent";
    }
}
