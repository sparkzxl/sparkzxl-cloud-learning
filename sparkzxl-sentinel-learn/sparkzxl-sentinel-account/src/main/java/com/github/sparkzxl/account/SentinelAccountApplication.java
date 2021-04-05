package com.github.sparkzxl.account;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: 账户启动类
 *
 * @author: zhouxinlei
 * @date: 2020-12-07 11:24:39
*/
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.account"})
@EnableFeignClients("com.github.sparkzxl.account.infrastructure.client")
@EnableDiscoveryClient
public class SentinelAccountApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelAccountApplication.class, args);
    }
}
