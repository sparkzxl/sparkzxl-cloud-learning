package com.github.sparkzxl.product.interfaces.controller;


import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.product.api.ProductApi;
import com.github.sparkzxl.product.application.service.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;

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
@WebLog
@ResponseResult
@RequestMapping("/product")
public class ProductController implements ProductApi {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public boolean reduceStock(Long productId, Integer amount) throws Exception {
        return productService.reduceStock(productId,amount);
    }
}
