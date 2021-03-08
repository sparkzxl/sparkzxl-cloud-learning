package com.github.sparkzxl.order.infrastructure.client;

import com.github.sparkzxl.account.api.AccountApi;
import com.github.sparkzxl.order.infrastructure.fallback.AccountFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(value = "sparkzxl-account-server",path ="/account",fallbackFactory = AccountFallbackFactory.class)
@Component
public interface AccountClient extends AccountApi {

}
