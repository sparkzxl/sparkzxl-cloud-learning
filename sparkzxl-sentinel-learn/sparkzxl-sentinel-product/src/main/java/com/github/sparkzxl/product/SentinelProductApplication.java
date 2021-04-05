package com.github.sparkzxl.product;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.product"})
public class SentinelProductApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelProductApplication.class, args);
    }
}
