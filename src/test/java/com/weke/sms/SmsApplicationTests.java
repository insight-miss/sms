package com.weke.sms;

import com.aliyuncs.exceptions.ClientException;
import com.weke.sms.util.SmsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsApplicationTests {

    @Autowired
    private SmsUtil smsUtil;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendSms() throws ClientException {
        String phoneNumbers = "15274436893";
        String signName = "唐文亮";
        String templateCode = "SMS_141195199";
        String templateParam = "{\"number\":\"123456\"}";
        smsUtil.sendSMs(phoneNumbers,signName,templateCode,templateParam);
    }
}
