package com.github.sparkzxl.order.infrastructure.fallback;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.order.infrastructure.client.ProductClient;
import feign.hystrix.FallbackFactory;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * description: 商品服务服务降级处理类
 *
 * @author: zhouxinlei
 * @date: 2020-12-08 17:03:10
*/
@Component
@Slf4j
public class ProductFallbackFactory implements FallbackFactory<ProductClient> {

    @Override
    public ProductClient create(Throwable throwable) {
        log.error("商品服务请求异常:{}", ExceptionUtil.getMessage(throwable));
        return (productId, amount) -> {
            String xid = RootContext.getXID();
            if (!StringUtils.isBlank(xid)) {
                try {
                    GlobalTransactionContext.reload(xid).rollback();
                } catch (TransactionException e) {
                    e.printStackTrace();
                }
            }
            return false;
        };
    }
}
