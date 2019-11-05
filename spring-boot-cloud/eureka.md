`springcloud`是微服务架构的集大成者，将一系列优秀的组件进行了整合。基于springboot构建，对我们熟悉spring的程序员来说，上手比较容易。

通过一些简单的注解，我们就可以快速的在应用中配置一下常用模块并构建庞大的分布式系统。

下面主要用图来理解下各个组件的概念吧

![Spring Cloud的组件](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719145209332-1168967345.png)

`Eureka`：全球（美国）/jʊ'rikə/ 

​		n. 尤里卡（美国地名）；优铜

​		n. （美）欧雷卡（人名）

​		int. (eureka) 我发现了，我找到了；有了

​	    **功能:服务注册与发现，各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从而知道其他服务在哪里**



`Ribbon`： 全球（美国）/'rɪbən/

​	  n. [动力] 涡轮；[动力] 涡轮机

  	**功能:服务请求调用客户端负载均衡，服务间发起请求的时候，基于Ribbon做负载均衡，从一个服务的多台机器中选择一台**  



`Feign`： 全球（英语）/feɪn/  

​	vt. 假装；装作；捏造；想象

​	vi. 假装；装作；作假；佯作

​	**功能：服务请求调用，基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求** 



`Hystrix`：hy /,etʃ 'waɪ/  strix /s坠x/      嗨s坠x 

​	短语：.豪猪属 猬草属 豪猪 断路器

​	**功能：熔断器，发起请求是通过Hystrix的线程池来走的，不同的服务走不同的线程池，实现了不同服务调用的隔离，避免了服务雪崩的问题** 



`Zuul`：/zuːl/    

​		短语:zuul 网关 路由网关 祖鲁乐团 静态文件

​		**功能：api路由网关，如果前端、移动端要调用后端系统，统一从Zuul网关进入，由Zuul网关转发请求给对应的服务**

​		**看别人博客的一句话，贴出来：当我对zuul有点映像的时候，它已经过时了，SpringCloud Gateway就诞生，这让我们这些33岁的老程序员怎么活呢。** 



`Sleuth`:  /sluθ/  

​		n. 侦探；警犬

​		vi. 做侦探；侦查

​		**功能：服务链路追踪，主要功能就是在分布式系统中提供追踪解决方案，并且兼容支持了 zipkin**



`Eureka` 是 Netflix 开发的，一个基于 REST 服务的，服务注册与发现的组件

它主要包括两个组件：`Eureka Server` 和 `Eureka Client`

Eureka Client：一个Java客户端，用于简化与 Eureka Server 的交互（通常就是微服务中的客户端和服务端）
Eureka Server：提供服务注册和发现的能力（通常就是微服务中的注册中心）

# Spring Cloud核心组件：Eureka 服务注册与发现

他有三端构成

1. Eureka Server 服务注册与发现中心端

2. Service Provider服务提供者端

3. Service Consumer服务调用者端

   ![](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719151607139-1493443998.png)

![](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719151304163-939259217.png)

# Spring Cloud核心组件：Feign

​		接口调用，restful风格http可以用调java接口方式去调用。

​		自己组装url与参数还有请求头等信息，不用自己去写啦。简单易用。

​		看下调用方式与代码

```java
//url=http://www.me.com@FeignClient(url = "${feign.order-promotion.url}")
public interface PromotionClient {
    @RequestMapping(value = "/Member/Promotion/ReleasePromtionByOrderId", method = RequestMethod.POST)
    BaseWcfResponse<Integer> ReleasePromtionByOrderId(@RequestBody ReleasePromtionReq request);
}
```



![img](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719151906476-2095680014.png)

# Spring Cloud核心组件：Ribbon

​		客户端负载均衡，一个服务部署多台机器的情况feign不知道调用那台服务，那么ribbon就可以使用默认abab的轮询算法，给确定那一台机器

![img](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719152804714-705746085.png)

## Spring Cloud核心组件：Hystrix

​		熔断器，个别服务接口挂拉，可能会影响整个服务链路，导致整体服务不可用，这个时候hystrix就派上用场啦。![img](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719153238796-284257826.png)

# Spring Cloud核心组件：Zuul

​		前端、移动端要调用后端系统，统一从Zuul网关进入，由Zuul网关转发请求给对应的服务

![img](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719153400827-1090321483.png)

# 整体项目架构图

![img](https://img2018.cnblogs.com/blog/398358/201907/398358-20190719180503049-276125572.png)

# 