package com.github.sparkzxl.order.interfaces.controller;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.order.application.service.IOrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
@RestController
@RequestMapping("/orders")
@WebLog
@ResponseResult
@Slf4j
public class OrdersController {

    private final IOrdersService orderService;

    public OrdersController(IOrdersService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Integer createOrder(@RequestParam("userId") Long userId,
                               @RequestParam("productId") Long productId,
                               @RequestParam("price") Integer price) throws Exception {
        log.info("[createOrder] 收到下单请求，用户：{}，商品：{}，价格：{}", userId, productId, price);
        return orderService.createOrder(userId, productId, price);

    }
}
