package com.admin.mapper;
//继承了BaseMapper,就可以拥有crud的基础功能
import com.admin.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
}
