package com.pradeek.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pradeek.demo.kafka.Producer;
import com.pradeek.demo.model.Student;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("v1")
public class RestController {
	
	@Autowired
	private Producer producer;
	
	@Value("${spring.kafka.incoming.topic}")
	private String TOPIC;
	
	@RequestMapping("/publish")
	public String toProudcer(@RequestBody Student student) {
		producer.pushIntoKafka(TOPIC, student);
		return "Successfully Sent";
	}
}
