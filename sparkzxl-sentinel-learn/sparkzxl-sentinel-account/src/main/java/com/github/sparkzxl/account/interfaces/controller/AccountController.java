package com.github.sparkzxl.account.interfaces.controller;


import com.github.sparkzxl.account.infrastructure.client.ProductClient;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.core.context.BaseContextHandler;
import com.github.sparkzxl.product.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-04-05
 */
@RestController
@ResponseResult
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("getAccountProduct")
    public ProductDto getAccountProduct(Long id) {
        BaseContextHandler.setUserId(100);
        return productClient.getProduct(id);
    }
}
