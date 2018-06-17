package com.kafka.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Srinivasu
 * https://dzone.com/articles/running-apache-kafka-on-windows-os
 *
 */
@RestController
public class MessageContoller {
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Value("${app.topic.foo}")
	private String topic;
	
	@GetMapping("/message")
	public String sendMessage(){
		
		String msg =  "Hi Mouni, Wie geht's. konnen Sie helfen. Was machst du gerade. Ich bin gut. ja."
				+ "Ich hoffe gut"
				+ "Ich habe eine Frage"
				+ "Wo ist das Bad" + "Wo ist die Toilette?" + "Wo ist der Bahnof?"
				+"Wer bist du? Wann kommst du (nach Haus). Kannst du mir helfen";
		kafkaTemplate.send(topic,msg);
		return msg;
	}
	
	

}
