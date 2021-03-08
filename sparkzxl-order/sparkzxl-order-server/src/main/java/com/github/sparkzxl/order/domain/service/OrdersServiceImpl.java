package com.github.sparkzxl.order.domain.service;

import com.github.sparkzxl.core.support.SparkZxlExceptionAssert;
import com.github.sparkzxl.order.infrastructure.client.AccountClient;
import com.github.sparkzxl.order.infrastructure.client.ProductClient;
import com.github.sparkzxl.order.infrastructure.entity.Orders;
import com.github.sparkzxl.order.infrastructure.mapper.OrdersMapper;
import com.github.sparkzxl.order.application.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
@Service
@Slf4j
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

    @Autowired
    private ProductClient productClient;
    @Autowired
    private AccountClient accountClient;


    @Override
    @GlobalTransactional
    public Integer createOrder(Long userId, Long productId, Integer price) throws Exception {
        Integer amount = 1;
        log.info("[createOrder] 当前XID：{}", RootContext.getXID());

        // <2> 扣减库存
        boolean reduceStock = productClient.reduceStock(productId, amount);
        if (!reduceStock){
            SparkZxlExceptionAssert.businessFail("库存不足");
        }

        // <3> 扣减余额
        accountClient.reduceBalance(userId, price);

        // <4> 保存订单
        Orders order = new Orders();
        order.setUserId(Math.toIntExact(userId));
        order.setProductId(Math.toIntExact(productId));
        BigDecimal bigDecimal = new BigDecimal(amount * price);
        order.setPayAmount(bigDecimal);
        save(order);
        log.info("[createOrder] 保存订单: {}", order.getId());

        // 返回订单编号
        return order.getId();
    }

}
