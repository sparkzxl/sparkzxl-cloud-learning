package com.github.sparkzxl.product.domain.service;

import com.github.sparkzxl.product.infrastructure.entity.Product;
import com.github.sparkzxl.product.infrastructure.mapper.ProductMapper;
import com.github.sparkzxl.product.application.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean reduceStock(Long productId, Integer amount) throws Exception {
        log.info("[reduceStock] 当前XID：{}", RootContext.getXID());

        //检查库存
        checkStock(productId,amount);

        log.info("[reduceStock] 开始扣减 {} 库存", productId);
        //扣减库存
        int updateCount = super.baseMapper.reduceStock(productId,amount);
        if (updateCount == 0) {
            log.warn("[reduceStock] 扣除 {} 库存失败",productId);
            throw new Exception("库存不足");
        }
        //扣除失败
        log.info("[reduceStock] 扣除 {} 库存成功", productId);
        return true;
    }

    //检查库存
    private void checkStock(Long productId, Integer requireAmount) throws Exception {
        log.info("[checkStock] 检查 {} 库存", productId);
        Integer stock = super.baseMapper.getStock(productId);
        if (stock < requireAmount) {
            log.warn("[checkStock] {} 库存不足，当前库存：{}",productId,stock);
            throw new Exception("库存不足");
        }
    }
}
