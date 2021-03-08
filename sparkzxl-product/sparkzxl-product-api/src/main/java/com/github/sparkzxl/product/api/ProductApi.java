package com.github.sparkzxl.product.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description: 商品api
 *
 * @author: zhouxinlei
 * @date: 2020-12-07 12:57:20
*/
public interface ProductApi {


    /**
     * 扣减库存
     *
     * @param productId 商品 ID
     * @param amount    扣减数量
     * @throws Exception 扣减失败时抛出异常
     */
    @GetMapping("/reduceStock")
    boolean reduceStock(@RequestParam("productId") Long productId, @RequestParam("amount") Integer amount) throws Exception;
}
