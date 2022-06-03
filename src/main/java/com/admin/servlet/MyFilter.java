package com.admin.servlet;
//做一个原生的Filter组件,也可以用MyRegistConfig的方式
import lombok.extern.slf4j.Slf4j;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})  这是一个Web的Filter组件,过滤拦截括号里的资源
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter工作");

        //对用户请求进行预处理,符合条件的请求才能进入下一过滤点(没有下个过滤点就直接到控制器那)
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
