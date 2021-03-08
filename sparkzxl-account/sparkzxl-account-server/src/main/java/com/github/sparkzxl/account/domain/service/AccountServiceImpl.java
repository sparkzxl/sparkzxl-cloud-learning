package com.github.sparkzxl.account.domain.service;

import com.github.sparkzxl.account.infrastructure.entity.Account;
import com.github.sparkzxl.account.infrastructure.mapper.AccountMapper;
import com.github.sparkzxl.account.application.service.IAccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean reduceBalance(Long userId, Integer price) throws Exception {
        log.info("[reduceBalance] 当前 XID：{}", RootContext.getXID());

        //检查余额
        checkBalance(userId,price);
        log.info("[reduceBalance] 开始扣减用户 {} 余额", userId);
        //扣除余额
        int updateCount = super.baseMapper.redecuPrice(price);
        if (updateCount == 0) {
            log.warn("[reduceBalance] 扣除用户 {} 余额失败", userId);
            throw new Exception("余额不足");
        }
        log.info("[reduceBalance] 扣除用户 {} 余额成功", userId);
        return true;
    }

    /**
     * 检查余额
     * @param userId 用户id
     * @param price 金额
     * @throws Exception 异常
     */
    private void checkBalance(Long userId, Integer price) throws Exception {
        log.info("[checkBalance] 检查用户 {} 余额",userId);
        Integer balance = super.baseMapper.getBalance(userId);
        if (balance < price) {
            log.warn("[checkBalance] 用户 {} 余额不足，当前余额 {}",userId,balance);
            throw new Exception("余额不足");
        }

    }
}
