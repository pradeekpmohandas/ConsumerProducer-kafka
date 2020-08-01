package com.pradeek.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.KafkaHeaders;
import com.pradeek.demo.model.Student;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
@KafkaListener(id = "#{'${spring.application.name}'}", topics = "#{'${spring.kafka.incoming.topic}'.split(',')}")
public class Consumer {


	@KafkaHandler
	 public void consume(Student student,@Header(KafkaHeaders.OFFSET) String offset){
	    log.info(" offset: " + offset + "Incoming info: "+student);
 	}
	


}
