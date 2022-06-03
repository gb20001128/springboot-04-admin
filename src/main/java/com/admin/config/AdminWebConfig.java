package com.admin.config;
//定制web功能的配置类
import com.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /*将拦截器注册到容器中,再指定拦截规则*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //指定拦截器拦截哪些请求
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sql","/love"); //放行的请求
    }
}
