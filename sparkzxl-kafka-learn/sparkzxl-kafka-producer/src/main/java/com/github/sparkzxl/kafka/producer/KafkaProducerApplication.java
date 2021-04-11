package com.github.sparkzxl.kafka.producer;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: kafka生产启动类
 *
 * @author zhouxinlei
 * @date 2021-04-11 10:42:02
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.kafka.producer"})
public class KafkaProducerApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

}
