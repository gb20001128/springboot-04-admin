package com.admin.controller;

import com.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {


    //登录页
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    //登录成功后的主页
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
         //判断User内容是否正确
        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassWord())){
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //回到登录页面
            return "login";
        }
    }

    //为防止表单重复提交,而采用的真正的主页
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        log.info("当前方法是:mainPage方法");
        return "main";
    }

    @GetMapping("/love")
    public String love(){
        return "love";
    }
}
