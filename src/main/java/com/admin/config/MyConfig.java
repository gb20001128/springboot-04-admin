package com.admin.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /*有了此MybatisPlus组件,才可以结合MybatisPlus的Page,实现分页*/
    @Bean
    public MybatisPlusInterceptor paginationInterceptor(){

        MybatisPlusInterceptor myba=new MybatisPlusInterceptor();
        //这是分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor=new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);//请求的页面大于最大页时,调回首页(被我真实了) false:继续请求
        paginationInnerInterceptor.setMaxLimit(500L);//单页最大500条记录
        myba.addInnerInterceptor(paginationInnerInterceptor);
        return myba;
    }

}
