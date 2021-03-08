package com.github.sparkzxl.account;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * description: 账户启动类
 *
 * @author: zhouxinlei
 * @date: 2020-12-07 11:24:39
*/
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.account"})
@EnableDiscoveryClient
public class AccountServiceApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
