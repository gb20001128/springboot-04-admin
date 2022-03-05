package com.admin.service;

import com.admin.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;
// IService是Mybatis plus所有Service层的总接口,继承这个总接口以便于实现Mybatis plus为我们提供的各种Service层的功能
public interface UserService extends IService<User> {

}
