package com.pc.pockafkaconsumidor.kafka;

import com.pc.pockafkaconsumidor.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${spring.kafka.topic}")
    public void viewDisplay(@Payload Message message, @Headers MessageHeaders headers) {
        LOG.info("received data='{}'", message);

        headers.keySet().forEach(key -> {
            LOG.info("{}: {}", key, headers.get(key));
        });
        System.out.println(message.getMessage());
    }
}
