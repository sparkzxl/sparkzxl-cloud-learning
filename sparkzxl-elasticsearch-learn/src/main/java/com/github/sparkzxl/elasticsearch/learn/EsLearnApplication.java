package com.github.sparkzxl.elasticsearch.learn;

import com.github.sparkzxl.boot.SparkBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: kafka生产启动类
 *
 * @author zhouxinlei
 * @date 2021-04-11 10:42:02
 */
@SpringBootApplication(scanBasePackages = {"com.github.sparkzxl.elasticsearch.learn"})
public class EsLearnApplication extends SparkBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsLearnApplication.class, args);
    }

}
