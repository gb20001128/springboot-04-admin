package com.admin.controller;

import com.admin.bean.User;
import com.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;


    @GetMapping("/basic_table")
    public String basic_table(){
        //int a=10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,
                             @RequestParam(value ="pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table( @RequestParam(value = "pn",defaultValue ="1") Integer pn, Model model){

        List<User> users = userService.list();
        //分页查询数据
        Page<User> userPage=new Page<>(pn,2);//规定当前的页码和记录数大小
        //分页查询的结果
        Page<User> page=userService.page(userPage,null);
        //请求页的页码大于总页数,就设置当前页数为总页数
        if(pn>page.getPages()){
            userPage=new Page<>(page.getPages(),2);
             page=userService.page(userPage,null);
        }
        model.addAttribute("page",page);//该page封装了操作数据库的n多方法
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
