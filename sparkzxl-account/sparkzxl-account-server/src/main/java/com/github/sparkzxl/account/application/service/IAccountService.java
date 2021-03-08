package com.github.sparkzxl.account.application.service;

import com.github.sparkzxl.account.infrastructure.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
public interface IAccountService extends IService<Account> {


    /**
     * 扣除余额
     *
     * @param userId 用户编号
     * @param price  扣减金额
     * @throws Exception 失败时抛出异常
     */

    boolean reduceBalance(Long userId, Integer price) throws Exception;

}
