package com.github.sparkzxl.account.interfaces.controller;


import com.github.sparkzxl.account.api.AccountApi;
import com.github.sparkzxl.account.application.service.IAccountService;
import com.github.sparkzxl.log.annotation.WebLog;
import com.github.sparkzxl.web.annotation.ResponseResult;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
@RestController
@WebLog
@ResponseResult
@RequestMapping("/account")
public class AccountController implements AccountApi {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public boolean reduceBalance(Long userId, Integer price) throws Exception {
        return accountService.reduceBalance(userId,price);
    }
}
