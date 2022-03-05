package com.admin.mapper;

import com.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper //标注这是Mapper接口
public interface AccountMapper {

     Account getAcct (Long id);
}
