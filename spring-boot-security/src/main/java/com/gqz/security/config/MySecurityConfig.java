package com.gqz.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassName MySecurityConfig
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/25 23:26
 * @Version
 **/

/*
The MySecurityConfig class is annotated with @EnableWebSecurity to enable Spring Security’s web security support and provide the Spring MVC integration.
It also extends WebSecurityConfigurerAdapter
and overrides a couple of its methods to set some specifics of the web security configuration.
 */

@EnableWebSecurity  //启用Spring Security的web安全支持并提供Spring MVC集成。
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    //定制请求的授权规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(web);
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        // http.formLogin();开启自动配置的登录功能，效果-- 如果没有登录，没有权限会来到登录页面
        /*
            修改默认设置/login   配置自定义规则.loginPage()
            usernameParameter("user")  绑定username参数为user默认为username
            passwordParameter("pwd")   绑定password参数为pwd默认为password
            说明：自定义登录表单中的请求路径为loginPage（）中定义的字符串，也可以用loginProcessingUrl()指定
            注意:loginPage中的/不要掉了，我一开始就写掉了！！
         */
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userLogin");//修改默认设置/login   配置自定义规则.loginPage()
        //1. /login来到登录页面
        //2. 重定向到/login?error表示登录失败
        //3.还有很多其他的详细规定


        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/"); //注销成功以后来到首页
        //1.访问/logout 表示用户注销，销毁session
        //2. 注销成功会返回 /logout?logout 页面

        //http.rememberMe()开启记住我remember me功能
        http.rememberMe().rememberMeParameter("remember"); //自定义登录表单中的请记住我  参数为rememberMeParameter()绑定
        //登录成功以后，将cookie发送给浏览器保存，以后访问页面带上这个cookie
        //只要通过验证就可以面登陆
        //点击注销 会删除cookie的

    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //从内存获取认证消息  正式环境中都是从jdbc中获取用户信息的
        auth.inMemoryAuthentication()
                //给ganquanzhong用户添加role VIP1、VIP2一个用户可以添加多个角色
                .withUser("ganquanzhong").password("123456").roles("VIP1","VIP2")
                .and()
                .withUser("chenrong").password("123456").roles("VIP1","VIP3")
                .and()
                .withUser("gqzdev").password("123456").roles("VIP2","VIP3");
    }
}
