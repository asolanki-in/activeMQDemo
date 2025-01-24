package com.example.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class ArtemisProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    public void send(String message){

        jmsTemplate.convertAndSend("example-topic", message, msg -> {
            msg.setStringProperty("subscriberId", "S1"); // Set custom property
            return msg;
        });
        //jmsTemplate.convertAndSend("JmsTopic", msg);
    }
}
