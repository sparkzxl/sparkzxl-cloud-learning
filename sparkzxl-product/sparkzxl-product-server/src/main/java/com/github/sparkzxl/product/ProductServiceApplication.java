package com.github.sparkzxl.product;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: 商品启动类
 *
 * @author: zhouxinlei
 * @date: 2020-12-07 11:24:39
*/
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.product"})
@EnableDiscoveryClient
public class ProductServiceApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
}
