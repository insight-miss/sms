package com.weke.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void send(String text) {
        jmsMessagingTemplate.convertAndSend("weke",text);
    }

    @RequestMapping("/sendMap")
    public void sendMap() {
        Map map = new HashMap<>();
        map.put("mobile","12345678");
        map.put("content","双十一开始秒杀");
        jmsMessagingTemplate.convertAndSend("itCast_map",map);
    }
}
