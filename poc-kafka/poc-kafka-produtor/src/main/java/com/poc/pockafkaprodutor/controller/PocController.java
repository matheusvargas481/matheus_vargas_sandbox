package com.poc.pockafkaprodutor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.pockafkaprodutor.dto.Message;
import com.poc.pockafkaprodutor.kafka.Producer;

@RestController
public class PocController {

	@Autowired
	private Producer producer;

	@PostMapping("/send-message")
	ResponseEntity<?> test(@RequestBody Message message) {
		producer.send(message);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
