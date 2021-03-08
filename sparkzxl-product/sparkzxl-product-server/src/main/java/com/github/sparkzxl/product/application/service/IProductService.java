package com.github.sparkzxl.product.application.service;

import com.github.sparkzxl.product.infrastructure.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
public interface IProductService extends IService<Product> {

    boolean reduceStock(Long productId, Integer amount) throws Exception;
}
