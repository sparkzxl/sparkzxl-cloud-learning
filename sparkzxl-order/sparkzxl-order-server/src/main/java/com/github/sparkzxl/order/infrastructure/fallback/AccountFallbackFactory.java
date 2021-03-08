package com.github.sparkzxl.order.infrastructure.fallback;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.order.infrastructure.client.AccountClient;
import feign.hystrix.FallbackFactory;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * description: 服务降级处理类
 *
 * @author: zhouxinlei
 * @date: 2020-12-08 17:04:28
*/
@Component
@Slf4j
public class AccountFallbackFactory implements FallbackFactory<AccountClient> {

    @Override
    public AccountClient create(Throwable throwable) {
        log.error("账户服务请求异常:{}", ExceptionUtil.getMessage(throwable));
        return (userId, price) -> {
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
