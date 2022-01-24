package com.goal.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * druid配置类
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控,必须放在spring容器里面！！！！@Bean
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台监控需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername","admin");			//登录的key是固定的，必须是loginUsername和loginPassword
        initParameters.put("loginPassword","1234");
        //允许谁可以访问
        initParameters.put("allow","");

        bean.setInitParameters(initParameters);
        return bean;
    }

}
