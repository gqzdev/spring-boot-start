package com.gqz.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DruidConfig
 * @author: ganquanzhong
 * @date: 2019/9/30 16:27
 */
@Configuration
public class DruidConfig {

    //注册属性源
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidSource(){

        return new DruidDataSource();
    }

    //配置Druid的监控
    //1.配置一个管理后台的Servlet
    //使用注解的方式添加三大组件 servlet filter listener
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String ,String > initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        initParams.put("allow","");//默认是允许所有的访问
        initParams.put("deny","10.202.228.123");

        //设置参数，传入map
        bean.setInitParameters(initParams);
        return bean;
    }


    //2.配置一个Web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        Map<String ,String > initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;

    }

}
