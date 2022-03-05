package com.admin.Test;

import com.admin.bean.Account;
import com.admin.bean.City;
import com.admin.service.AccountService;
import com.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Test1 {

    @Autowired
    AccountService accountService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityService cityService;

    //整合mybatis的小测试
    @GetMapping("/acct")
    public Account test01(@RequestParam("id") Long id){
        return accountService.getAcct(id);
    }

    //spring自带jdbcTemplate工具的使用测试
    @GetMapping("/sql")
    public String queryFormDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_book", Long.class);
        return aLong.toString();
    }

    //注解方式的mybatis使用
    @GetMapping("/city1")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getCityById(id);
    }

    //注解方式和配置方式可以在一个Mapper中混合使用
    @GetMapping("/city2")
    public City insert(){
       City city= new City(null,"gh","8","武汉");
        cityService.insert(city);
        return city;
    }

}
