package com.github.sparkzxl.product.api;

import com.github.sparkzxl.product.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-04-05 17:30:57
 */
public interface IProductApi {

    /**
     * 查询商品信息
     *
     * @param id 商品id
     * @return ProductDto
     */
    @GetMapping("/getProduct")
    ProductDto getProduct(@RequestParam(value = "id") Long id);
}
