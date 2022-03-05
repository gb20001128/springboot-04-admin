package com.admin.config;
//注意:下面的配置已过时,我们完全可以在配置文件中设置所有
//数据源的配置类,将druid作为数据源,并开启druid的n多监控功能
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
@Deprecated //标注过时了,反对使用
//@Configuration
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource") //与配置文件中的spring的datasource绑定
    @Bean
    public DataSource dataSource() throws SQLException {
       DruidDataSource druidDataSource =new DruidDataSource();
        druidDataSource.setFilters("stat,wall");//开启统计监控信息和防火墙功能(druidDataSource的所有属性都可以在配置文件中指定)
       return druidDataSource;
    }

    //配置druid的监控页功能(我觉得应该是每个数据库连接池都有统计视图,在这就是创建统计视图,把统计视图注册进原生Servlet里面,而且设置统计视图的请求路径)
    @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet=new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean=new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        registrationBean.addInitParameter("loginUsername","admin");//设置访问监控页的账号
        registrationBean.addInitParameter("loginPassword","123456");//设置访问监控页的密码
        return registrationBean;
    }

    //将Web统计过滤器注册进原生过滤器里面,webStatFilter:用于采集web-jdbc关联监控的数据
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter=new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean=new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));//设置监控的请求路径为所有请求
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");//排除的请求路径
        return  filterRegistrationBean;
    }

}
