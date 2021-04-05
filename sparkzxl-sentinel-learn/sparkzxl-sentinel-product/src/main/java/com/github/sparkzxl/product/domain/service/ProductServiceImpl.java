package com.github.sparkzxl.product.domain.service;

import com.github.sparkzxl.product.infrastructure.entity.Product;
import com.github.sparkzxl.product.infrastructure.mapper.ProductMapper;
import com.github.sparkzxl.product.application.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-04-05
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
