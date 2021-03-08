package com.github.sparkzxl.order.application.service;

import com.github.sparkzxl.order.infrastructure.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
public interface IOrdersService extends IService<Orders> {

    Integer createOrder(Long userId, Long productId, Integer price) throws Exception;
}
