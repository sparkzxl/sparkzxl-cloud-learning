package com.github.sparkzxl.account.infrastructure.fallback;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.github.sparkzxl.account.infrastructure.client.ProductClient;
import com.github.sparkzxl.product.dto.ProductDto;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-04-05 17:37:31
 */
@Component
@Slf4j
public class ProductFallbackFactory implements FallbackFactory<ProductClient> {

    @Override
    public ProductClient create(Throwable throwable) {
        log.error("商品服务请求异常:{}", ExceptionUtil.getMessage(throwable));
        return (id) -> new ProductDto();
    }
}
