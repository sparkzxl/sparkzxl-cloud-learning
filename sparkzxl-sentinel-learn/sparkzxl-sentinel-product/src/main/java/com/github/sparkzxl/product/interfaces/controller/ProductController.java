package com.github.sparkzxl.product.interfaces.controller;


import com.github.sparkzxl.core.context.BaseContextHandler;
import com.github.sparkzxl.product.api.IProductApi;
import com.github.sparkzxl.product.application.service.IProductService;
import com.github.sparkzxl.product.dto.ProductDto;
import com.github.sparkzxl.product.infrastructure.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/product")
public class ProductController implements IProductApi {

    @Autowired
    private IProductService productService;

    @Override
    public ProductDto getProduct(Long id) {
        System.out.println(BaseContextHandler.getUserId(Integer.TYPE));
        Product product = productService.getById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }
}
