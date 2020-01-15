package com.matheusvargas481.springbootwithkafka.controller;


import com.matheusvargas481.springbootwithkafka.engine.KafkaSender;
import com.matheusvargas481.springbootwithkafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    @Autowired
    KafkaSender kafkaSender;

    @GetMapping
    public ResponseEntity<String> producer() {
        kafkaSender.send("Hello World !");
        return ResponseEntity.ok("Hello World !");
    }
}
