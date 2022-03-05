package com.admin;

import com.admin.bean.User;
import com.admin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {

        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_book", Long.class);
        log.info("记录总数:{}",aLong);
        log.info("数据源类型:{}",dataSource.getClass());
    }

    @Autowired
    UserMapper userMapper;

    //测试mybatis puls的使用
    @Test
    public void testMapper(){
        User user=userMapper.selectById(1L);
        System.out.println("用户信息:"+user);
    }
}
