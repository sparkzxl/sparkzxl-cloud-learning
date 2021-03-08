package com.github.sparkzxl.account.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AccountApi {

    @GetMapping("/reduceBalance")
    boolean reduceBalance(@RequestParam("userId") Long userId, @RequestParam("price")Integer price) throws Exception;
}
