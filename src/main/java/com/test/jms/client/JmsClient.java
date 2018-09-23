package com.test.jms.client;

public interface JmsClient {
	public void send(String msg);
	public String receive();
}
