package com.github.sparkzxl.nacos;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: nacos provider
 *
 * @author charles.zhou
 * @date 2021-05-11 10:41:35
*/
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.nacos"})
public class NacosProviderApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

}
