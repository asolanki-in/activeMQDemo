package com.example.Subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.JmsListener;

@SpringBootApplication
public class SubscriberApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriberApplication.class, args);
	}

	@JmsListener(destination = "JmsTopic", containerFactory = "jmsListenerContainerFactory", id = "S2")
	public void processToDo(String message) {
		System.out.println(message);
	}

}
