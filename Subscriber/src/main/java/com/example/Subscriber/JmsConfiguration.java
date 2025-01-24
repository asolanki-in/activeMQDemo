package com.example.Subscriber;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
public class JmsConfiguration {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactory());
        factory.setTransactionManager(transactionManager());
        factory.setSessionTransacted(true);
        return factory;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("amqp://localhost:5672", "admin", "admin");
        factory.setCallTimeout(30000);
        factory.setReconnectAttempts(5);
        return factory;
    }

    @Bean
    public JmsTransactionManager transactionManager() {
        return new JmsTransactionManager(connectionFactory());
    }
}


/*
*
* @JmsListener(destination = "JmsTopic", containerFactory = "jmsListenerContainerFactory", id = "2")
	public void processToDo(String message) {
		System.out.println(message);
	}
* */