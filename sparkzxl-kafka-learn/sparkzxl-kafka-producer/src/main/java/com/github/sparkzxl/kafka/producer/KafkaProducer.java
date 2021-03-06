package com.github.sparkzxl.kafka.producer;

import cn.hutool.core.util.IdUtil;
import com.github.sparkzxl.kafka.api.entity.JsonMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

import java.util.Locale;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void syncSend() {
        // 创建 Demo01Message 消息
        JsonMessage message = new JsonMessage();
        message.setUserId(IdUtil.getSnowflake(0, 10).nextId());
        Faker faker = new Faker(Locale.CHINA);
        message.setUserName(faker.name().fullName());
        // 同步发送消息
        kafkaTemplate.send(JsonMessage.TOPIC_NAME, message).addCallback(success -> {
            // 消息发送到的topic
            assert success != null;
            String topic = success.getRecordMetadata().topic();
            // 消息发送到的分区
            int partition = success.getRecordMetadata().partition();
            // 消息在分区内的offset
            long offset = success.getRecordMetadata().offset();
            log.info("kafka发送消息成功:[{}]:[{}]:[{}]", topic, partition, offset);
        }, failure -> log.info("kafka发送消息失败:[{}]", failure.getMessage()));
    }
}
