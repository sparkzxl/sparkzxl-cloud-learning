package com.github.sparkzxl.order.infrastructure.client;

import com.github.sparkzxl.order.infrastructure.fallback.ProductFallbackFactory;
import com.github.sparkzxl.product.api.ProductApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "sparkzxl-product-server",path = "/product",fallbackFactory = ProductFallbackFactory.class)
@Component
public interface ProductClient extends ProductApi {
}
