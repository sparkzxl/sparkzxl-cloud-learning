package com.github.sparkzxl.kafka.producer.controller;

import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.kafka.producer.KafkaProducer;
import com.github.sparkzxl.log.annotation.WebLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@ResponseResult
@WebLog
@RequestMapping("kafka")
@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("producer")
    public boolean kafkaProducer() {
        kafkaProducer.syncSend();
        return true;
    }
}
