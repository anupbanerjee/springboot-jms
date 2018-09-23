package com.test.jms.client.impl;

import com.test.jms.client.JmsClient;
import com.test.jms.consumer.JmsConsumer;
import com.test.jms.producer.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JmsClientImpl implements JmsClient {

	@Autowired
    JmsConsumer jmsConsumer;
	
	@Autowired
    JmsProducer jmsProducer;
	
	@Override
	public void send(String msg) {
		jmsProducer.send(msg);
	}

	@Override
	public String receive() {
		return jmsConsumer.receive();
	}

}
