package com.github.sparkzxl.kafka.customer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * description: messages
 *
 * @author zhouxinlei
 * @date 2021-04-11 10:45:13
*/
@Data
public class JsonMessage implements Serializable {

    private static final long serialVersionUID = 7888106307455991564L;

    public static final String TOPIC_NAME = "sparkzxl-kafka-test1";

    private Long userId;

    private String userName;

    private String action;
}
