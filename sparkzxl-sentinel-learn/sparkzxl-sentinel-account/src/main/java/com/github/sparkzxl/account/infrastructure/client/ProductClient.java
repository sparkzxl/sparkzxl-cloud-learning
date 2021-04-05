package com.github.sparkzxl.account.infrastructure.client;

import com.github.sparkzxl.account.infrastructure.fallback.ProductFallbackFactory;
import com.github.sparkzxl.product.api.IProductApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-04-05 17:32:19
 */
@FeignClient(value = "sparkzxl-sentinel-product", path = "/product", fallbackFactory = ProductFallbackFactory.class)
@Component
public interface ProductClient extends IProductApi {

}
