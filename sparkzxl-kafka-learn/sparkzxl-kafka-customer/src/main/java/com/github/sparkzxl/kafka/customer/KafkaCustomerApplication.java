package com.github.sparkzxl.kafka.customer;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: kafka消费启动类
 *
 * @author zhouxinlei
 * @date 2021-04-11 10:42:02
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.kafka.customer"})
public class KafkaCustomerApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaCustomerApplication.class, args);
    }

}
