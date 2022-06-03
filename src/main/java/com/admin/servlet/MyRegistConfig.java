package com.admin.servlet;
//一个配置类,把Servlet、Filter、Listener放进容器中
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
public class MyRegistConfig {

    //Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    //Filter
    @Bean
    public FilterRegistrationBean myFilter(){

        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*")); //要过滤的请求
        return filterRegistrationBean;
    }

    //Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener mySwervletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(mySwervletContextListener);
    }
}