package com.pradeek.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import com.pradeek.demo.model.Student;

@Configuration
public class Producer {

	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;
	
	
	public String pushIntoKafka(String topic, Student student) {
		try {
			kafkaTemplate.send(topic, student);
			return "success";

		} catch (Exception e) {
			return "failed";
		}
	}

}
