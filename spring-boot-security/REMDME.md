>这是一个使用Spring Boot快速集成Spring Security的demo

可以参照
[官方文档](https://spring.io/guides/gs/securing-web/)
[官方的示例项目](https://github.com/spring-guides/gs-securing-web)

`Spring Security`是针对Spring项目的安全框架，也是Spring Boot底层安全模块默认的技术选型。
他可以实现强大的web安全控制。对于安全控制，我们仅需引入spring-boot-starter-security模块，进行少量的配置，即可实现强大的安全管理。

>几个类：`WebSecurityConfigurerAdapter`：
自定义Security策略`AuthenticationManagerBuilder`：
自定义认证策略`@EnableWebSecurity`：开启WebSecurity模式


自己使用过程中总结的点

> start   
  >>  1. 引入'SpringSecurity'  ;
  >>  2. 编写SpringSecurity的配置类
        @EnableWebSecurity   extends WebSecurityConfigurerAdapter
  >>  3. 控制请求的访问权限


遇到的问题issue
> 使用springboot，权限管理使用spring security，使用内存用户验证，但无响应报错：
  ```java 
  java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
  ```
> 解决方法：
这是因为Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，
`此版本需要提供一个PasswordEncorder的实例`，否则后台汇报错误==
```
  java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
```
并且页面毫无响应。
因此，需要创建PasswordEncorder的实现类。

>使用thymeleaf对spring-security的支持thymeleaf-extras-springsecurity

`遇到的坑` 
spring5和spring4在写命令空间是有所不同
xmlns:sec="http://www.thymeleaf.org/extras/spring-security"
xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4"