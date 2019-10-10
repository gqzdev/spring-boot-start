package com.gqz.springboot.config;

import com.gqz.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @title: MyMvcConfig
 * @author: ganquanzhong
 * @create: 2019-06-14 15:44
 **/
//使用WebMvcConfigurer可以来扩展SpringMVC的功能

//@EnableWebMvc //该注解表示Spring Boot对Spring MVC的自动配置失效

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 这里配置的MyMvcConfig配置的组件会和Spring Boot自动配置的一起生效
     */

    @Override
    //浏览器发送/gqz 请求来到success
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/gqz").setViewName("success");
    }

    //注册拦截器
    //静态资源； *.js *.css
    //SpringBoot已经做好了静态资源映射
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).
//                addPathPatterns("/**").
//                excludePathPatterns("/index.html","/", "/user/login", "/webjars/**","/asserts/**");
    }

    //WebMvcConfigurer  webmvc的配置类
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        //内部类
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }
        };
        return adapter;
    }

    //添加localResolver
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
