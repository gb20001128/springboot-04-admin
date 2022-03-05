package com.admin.service.impl;
//Service层
import com.admin.bean.Account;
import com.admin.mapper.AccountMapper;
import com.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcct (Long id){
        return accountMapper.getAcct(id);
    }
}
