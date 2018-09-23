package com.test.jms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.jms.client.JmsClient;

@RestController
public class MessageController {
	
	@Autowired
	JmsClient jsmClient;
	
	@RequestMapping(value="/produce")
	public String produce(@RequestParam("msg")String msg){
		jsmClient.send(msg);
		return "Done";
	}
	
	@RequestMapping(value="/consume")
	public String consume(){
		return jsmClient.receive();
	}
}
