package com.pradeek.demo.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradeek.demo.model.Student;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@KafkaListener(id = "#{'${spring.application.name}'}", topics = "#{'${spring.kafka.incoming.topic}'.split(',')}")
public class Consumer {


	@KafkaHandler
	 public void consume(@Payload String student,@Header(KafkaHeaders.OFFSET) String offset){
	    log.info(" offset: " + offset + "Incoming info: "+student);
	      try {
	            ObjectMapper mapper = new ObjectMapper();
	            Student json = mapper.readValue(student, Student.class);
	            log.info("Json  :"+json);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	            log.error(e.getMessage());
	        }
	    
 	}
}
