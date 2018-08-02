package com.weke.sms.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    @JmsListener(destination = "weke")
    public void readMessage(String text) {
        System.out.println("收到新消息:"+text);
    }

    @JmsListener(destination = "itCast_map")
    public void readMapMessage(Map map) {
        System.out.println(map);
    }
}
