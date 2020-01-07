package com.pc.pockafkaconsumidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication
public class PocKafkaConsumidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocKafkaConsumidorApplication.class, args);
	}

}
