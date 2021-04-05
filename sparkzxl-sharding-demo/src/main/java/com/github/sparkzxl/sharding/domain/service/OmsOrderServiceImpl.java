package com.github.sparkzxl.sharding.domain.service;

import com.github.sparkzxl.database.base.service.impl.SuperCacheServiceImpl;
import com.github.sparkzxl.sharding.domain.repository.IOrderRepository;
import com.github.sparkzxl.sharding.infrastructure.constant.OrderConstant;
import com.github.sparkzxl.sharding.infrastructure.entity.OmsOrder;
import com.github.sparkzxl.sharding.infrastructure.mapper.OmsOrderMapper;
import com.github.sparkzxl.sharding.application.service.IOmsOrderService;
import org.springframework.stereotype.Service;

/**
 * description: 订单 服务实现类
 *
 * @author: zhouxinlei
 * @date: 2020-07-10 13:53:23
*/
@Service
public class OmsOrderServiceImpl extends SuperCacheServiceImpl<OmsOrderMapper, OmsOrder> implements IOmsOrderService {

    private final IOrderRepository orderRepository;

    public OmsOrderServiceImpl(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    protected String getRegion() {
        return OrderConstant.OMS_ORDER;
    }

    @Override
    public OmsOrder getByMemberId(Long memberId) {
        return orderRepository.getByMemberId(memberId);
    }
}
