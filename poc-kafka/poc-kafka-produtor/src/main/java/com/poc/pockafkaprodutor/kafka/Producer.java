package com.poc.pockafkaprodutor.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.poc.pockafkaprodutor.dto.Message;

@Component
public class Producer {

	@Value(value = "${spring.kafka.topic}")
	private String topic;

	private KafkaTemplate<String, Message> kafkaTemplate;

	public Producer(KafkaTemplate<String, Message> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(Message message) {
		kafkaTemplate.send(topic, message);
	}
}
