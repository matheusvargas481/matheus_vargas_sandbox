package com.matheusvargas481.pockafkadocker.controller;

import com.matheusvargas481.pockafkadocker.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class ClientController {

    private KafkaTemplate<String, Client> kafkaTemplate;

    @Autowired
    public ClientController(KafkaTemplate<String, Client> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void post(@RequestBody Client client) {
        kafkaTemplate.send("myTopic", client);
    }

}