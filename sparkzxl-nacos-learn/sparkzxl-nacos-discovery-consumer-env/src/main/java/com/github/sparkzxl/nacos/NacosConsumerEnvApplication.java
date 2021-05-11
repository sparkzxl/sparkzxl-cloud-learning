package com.github.sparkzxl.nacos;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * description: nacos consumer
 *
 * @author charles.zhou
 * @date 2021-05-11 10:41:35
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.nacos"})
public class NacosConsumerEnvApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerEnvApplication.class, args);
    }


    @Configuration
    public class RestTemplateConfiguration {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }

    }

}
