package com.github.sparkzxl.account.domain.service;

import com.github.sparkzxl.account.infrastructure.entity.Account;
import com.github.sparkzxl.account.infrastructure.mapper.AccountMapper;
import com.github.sparkzxl.account.application.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouxinlei
 * @since 2021-04-05
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {

}
