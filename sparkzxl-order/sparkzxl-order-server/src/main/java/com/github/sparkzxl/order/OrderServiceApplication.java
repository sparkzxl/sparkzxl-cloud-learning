package com.github.sparkzxl.order;

import com.github.sparkzxl.boot.SparkBootApplication;
import com.github.sparkzxl.feign.annoation.EnableFeignExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: 订单启动类
 *
 * @author: zhouxinlei
 * @date: 2020-12-07 11:24:39
*/
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.order"})
@EnableFeignClients("com.github.sparkzxl.order.infrastructure.client")
@EnableFeignExceptionHandler
public class OrderServiceApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
