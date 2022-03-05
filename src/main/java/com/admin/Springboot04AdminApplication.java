package com.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.admin.mapper")//指定mapper存在的包,那样每一个mapper就不用标注@Mapper了
@ServletComponentScan(basePackages="com.admin") //指定Web原生组件所放的包
@SpringBootApplication
public class Springboot04AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04AdminApplication.class, args);
    }

}
