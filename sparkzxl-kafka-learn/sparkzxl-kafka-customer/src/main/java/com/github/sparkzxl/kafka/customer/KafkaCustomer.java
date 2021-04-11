package com.github.sparkzxl.kafka.customer;

import com.github.sparkzxl.kafka.api.entity.JsonMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-04-11 11:15:24
 */
@Component
@Slf4j
public class KafkaCustomer {

    @KafkaListener(topics = JsonMessage.TOPIC_NAME,
            groupId = "kafka-test-consumer-group-a-" + JsonMessage.TOPIC_NAME)
    public void onMessage(JsonMessage message) {
        log.info("kafka:[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), message);
    }
}
