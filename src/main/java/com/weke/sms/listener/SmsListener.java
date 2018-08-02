package com.weke.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.weke.sms.util.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {

    @Autowired
    SmsUtil smsUtil;

    @JmsListener(destination = "sms")
    public void sendSms(Map<String,String> map) {
        String phoneNumbers = map.get("phoneNumbers");
        String signName = map.get("signName");
        String templateCode = map.get("templateCode");
        String templateParam = map.get("templateParam");
        try {
            smsUtil.sendSMs(phoneNumbers, signName, templateCode, templateParam);
            System.out.println("发送成功");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
