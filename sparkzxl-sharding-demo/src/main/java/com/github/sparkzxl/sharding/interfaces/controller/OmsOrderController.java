package com.github.sparkzxl.sharding.interfaces.controller;


import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.sharding.application.service.IOmsOrderService;
import com.github.sparkzxl.sharding.infrastructure.entity.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * description: 订单表 前端控制器
 *
 * @author: zhouxinlei
 * @date: 2020-07-10 13:55:00
 */
@RestController
@RequestMapping("/order")
@ResponseResult
@WebLog
@Api(tags = "订单管理")
public class OmsOrderController {

    private final IOmsOrderService omsOrderService;

    public OmsOrderController(IOmsOrderService omsOrderService) {
        this.omsOrderService = omsOrderService;
    }

    @ApiOperation("查询用户订单数据")
    @GetMapping("/order/{memberId}")
    public OmsOrder getByMemberId(@PathVariable("memberId") Long memberId) {
        return omsOrderService.getByMemberId(memberId);
    }

}
