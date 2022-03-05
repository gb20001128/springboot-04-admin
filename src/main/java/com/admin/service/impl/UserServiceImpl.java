package com.admin.service.impl;

import com.admin.bean.User;
import com.admin.mapper.UserMapper;
import com.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
// ServiceImpl 实现了总接口IService,泛型里面指定的是要操作的Mapper接口和数据类型
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
}
