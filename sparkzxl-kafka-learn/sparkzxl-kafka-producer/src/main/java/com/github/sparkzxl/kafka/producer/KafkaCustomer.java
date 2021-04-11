package com.github.sparkzxl.kafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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

    @KafkaListener(topics = "sparkzxl-kafka-test",
            groupId = "kafka-test-consumer-group-b-" + "sparkzxl-kafka-test")
    public void onMessage(ConsumerRecord<Integer, String> record) {
        log.info("[onMessage][线程编号:{} 消息内容：{}]", Thread.currentThread().getId(), record);
    }
}
