package com.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@TableName("user") //指定此pojo对应数据库中的那张表,默认是pojo名
public class User {

    //用户登录的字段
    @TableField(exist = false)//此字段在数据库中不存在
    private String userName;
    @TableField(exist = false)
    private String passWord;


    //数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;

}
