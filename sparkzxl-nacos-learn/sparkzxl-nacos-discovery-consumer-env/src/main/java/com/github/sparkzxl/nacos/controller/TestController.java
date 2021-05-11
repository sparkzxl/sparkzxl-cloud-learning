package com.github.sparkzxl.nacos.controller;

import com.github.sparkzxl.core.annotation.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * description: test
 *
 * @author charles.zhou
 * @date 2021-05-11 10:47:54
 */
@RestController
@ResponseResult
@Api(tags = "测试")
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @ApiOperation("echo")
    @GetMapping("/hello")
    public String hello(String name) {
        // <1> 获得服务 `nacos-provider` 的一个实例
        ServiceInstance instance;
        if (true) {
            // 获取服务 `nacos-provider` 对应的实例列表
            List<ServiceInstance> instances = discoveryClient.getInstances("nacos-provider");
            // 选择第一个
            instance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            instance = loadBalancerClient.choose("nacos-provider");
        }
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/echo?name=" + name;
        String response = restTemplate.getForObject(targetUrl, String.class);
        // 返回结果
        return "consumer:" + response;
    }
}
