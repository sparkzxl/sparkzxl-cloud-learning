package com.github.sparkzxl.nacos.controller;

import com.github.sparkzxl.core.annotation.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("echo")
    @GetMapping("/echo")
    public String echo(String name) {
        return "provider:" + name;
    }

}
