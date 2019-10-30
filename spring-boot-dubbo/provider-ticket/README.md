# Dubbo

a high-performance, java based open source RPC framework.



[Dubbo官网](http://dubbo.apache.org/en-us/) [源码](https://github.com/apache/dubbo) [文档](http://dubbo.apache.org/zh-cn/docs/user/preface/background.html)

## 快速知道用法

## 本地服务 Spring 配置

local.xml:

```xml
<bean id=“xxxService” class=“com.xxx.XxxServiceImpl” />
<bean id=“xxxAction” class=“com.xxx.XxxAction”>
    <property name=“xxxService” ref=“xxxService” />
</bean>
```

## 远程服务 Spring 配置

在本地服务的基础上，只需做简单配置，即可完成远程化：

- 将上面的 `local.xml` 配置拆分成两份，将服务定义部分放在服务提供方 `remote-provider.xml`，将服务引用部分放在服务消费方 `remote-consumer.xml`。
- 并在提供方增加暴露服务配置 `<dubbo:service>`，在消费方增加引用服务配置 `<dubbo:reference>`。

remote-provider.xml:

```xml
<!-- 和本地服务一样实现远程服务 -->
<bean id=“xxxService” class=“com.xxx.XxxServiceImpl” /> 
<!-- 增加暴露远程服务配置 -->
<dubbo:service interface=“com.xxx.XxxService” ref=“xxxService” /> 
```

remote-consumer.xml:

```xml
<!-- 增加引用远程服务配置 -->
<dubbo:reference id=“xxxService” interface=“com.xxx.XxxService” />
<!-- 和本地服务一样使用远程服务 -->
<bean id=“xxxAction” class=“com.xxx.XxxAction”> 
    <property name=“xxxService” ref=“xxxService” />
</bean>
```



# Spring Boot中使用Dubbo

[阿里官方demo](https://github.com/alibaba/dubbo-spring-boot-starter)

[dubbo-spring-boot-project](https://github.com/apache/dubbo-spring-boot-project/blob/0.1.x/README_CN.md)

  [Dubbo Spring Boot (v0.1.0)](https://github.com/dubbo/dubbo-spring-boot-project) : https://github.com/dubbo/dubbo-spring-boot-project
  [Dubbo (v2.0.1)](https://github.com/alibaba/dubbo) : https://github.com/alibaba/dubbo
  [Google group](http://groups.google.com/group/dubbo) : http://groups.google.com/group/dubbo


# issue
>其中经常遇到空指针异常，不能调用远程的服务
主要是Dubbo配置、注解、版本等问题。
严格参照官方的demo，不同版本可能出现一些架构方面的变更。

# Dubbo Spring Boot 工程

[![Build Status](https://travis-ci.org/apache/dubbo-spring-boot-project.svg?branch=master)](https://travis-ci.org/apache/dubbo-spring-boot-project) 
[![codecov](https://codecov.io/gh/apache/dubbo-spring-boot-project/branch/master/graph/badge.svg)](https://codecov.io/gh/apache/dubbo-spring-boot-project)
![license](https://img.shields.io/github/license/apache/dubbo-spring-boot-project.svg)

[Dubbo](https://dubbo.apache.org/zh-cn/index.html) Apache Dubbo™ 是一款高性能Java RPC框架。
[Spring Boot](https://github.com/spring-projects/spring-boot/) 应用场景的开发。同时也整合了 Spring Boot 特性：

* [自动装配](dubbo-spring-boot-autoconfigure) (比如： 注解驱动, 自动装配等).
* [Production-Ready](dubbo-spring-boot-actuator) (比如： 安全, 健康检查, 外部化配置等).

> Apache Dubbo  |ˈdʌbəʊ| 是一款高性能、轻量级的开源Java RPC框架，它提供了三大核心能力：面向接口的远程方法调用，智能容错和负载均衡，以及服务自动注册和发现。