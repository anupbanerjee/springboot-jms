package com.test.jms.factory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.rabbitmq.jms.admin.RMQConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * Connection Factory Is Not Required for ActiveMQ Connection.
 * This is only required if you are using RabbitMQ
 */

@Configuration
@ComponentScan
public class ConnFactory {

    private static final Log log = LogFactory.getLog(ConnFactory.class);

    @Value("${amqp.uri}")
    String amqpURI;

    @Value("${amqp.host}")
    String host;

    @Value("${amqp.username}")
    String username;

    @Value("${amqp.password}")
    String password;

    @Value("${amqp.vhost}")
    String vhost;

    @Bean
    ConnectionFactory connectionFactory() {

        log.info("Connecting to RabbitMQ at URI:"+amqpURI);
        RMQConnectionFactory rmqcf = new RMQConnectionFactory();
        try {
            if(!"default".equals(amqpURI)) {
                rmqcf.setUri(amqpURI);
            }
            else {
                rmqcf.setHost(host);
                rmqcf.setUsername(username);
                rmqcf.setPassword(password);
                if(vhost == null || " ".equals(vhost)) { vhost="/"; }
                rmqcf.setVirtualHost(vhost);
                System.out.println("The URI: "+rmqcf.getUri());
            }
        } catch(Exception e) {
            rmqcf = null;
            log.error(e.toString());
        }
        return rmqcf;
    }

}