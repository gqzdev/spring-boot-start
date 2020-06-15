package com.gqzdev.cache.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 *搭建基本环境
 * 1.导入数据库文件，创建数据表department和employee
 * 2.创建javabean封装数据
 * 3.整合MyBatis操作数据库
 *         1.配置数据源信息
 *         2.使用注解版的MyBatis
 *              1.@MapperScan指定需要扫描mapper接口所在的包
 *
 *
 *快速体验缓存
 *      步骤
 *          1.开启基于注解的缓存 @EnableCaching
 *          2.标注缓存注解即可
 *              @Cacheable
 *              @CacheEvict
 *              @CachePut
 *
 *      原理
 *          1.自动配置类 CacheAutoConfiguration
 *          2.缓存的配置类 imports返回一个组件数组
 *
 *              0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
 *              1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
 *              2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
 *              3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
 *              4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
 *              5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
 *              6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
 *              7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
 *              8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
 *              9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
 *          3.哪个配置类默认生效，SimpleCacheConfiguration
 *
 *          4.给容器中注册了一个CacheManager；ConcurrentMapCacheManager
 *          5.可以获取和创建ConcurrentMapCache类型的缓存组件；
 *              他的作用将数据保存在ConcurrentMap中
 *
 *
 *      步骤 cache缓存的执行流程
 *          1.方法运行之前，先去查询cache（缓存组件）,按照cacheNames指定的名字获取；
 *              （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建
 *          2.去Cache中查找缓存的内容，使用一个key，默认是方法的参数
 *              key是按照某种策略生成的，默认使用SimpleKeyGenerator生成的key；
 *              SimpleKeyGenerator生成key的默认策略为：
 *                  如果没有参数：key=new SimpleKey();
 *                  如果有一个参数：key=参数的值
 *                  如果有多个参数： key=new SimpleKey(params);
 *          3.没有查询到缓存就调用目标方法
 *          4.将目标方法返回的结果，放进缓存中
 *
 * @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据。默认是按照参数的值作为key去查村缓存
 * 如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据
 *      核心：
 *          1.使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMap】组件
 *          2.key使用keyGenerator生成的，默认是SimpleGenerator
 *
 *
 * Spring Boot默认的是使用ConcurrentMapCache ConcurrentMapCache
 *      将数据保存在ConcurrentMap<Object,String>
 * 开发中经常使用的缓存中间件：redis, memcached ,ehcache
 *
 * 整合Redis作为缓存
 *  1.安装redis ,使用Docker安装
 *  2.在Spring Boot应用中引入redis的starter
 *  3.配置redis后，CacheManager切换为RedisCacheManager(自动配置注入)
 *
 * @author ganquanzhong
 * @date   2019/10/10 15:06
 */

@MapperScan("com.gqzdev.cache.redis.mapper") /*扫描mapper*/
@EnableCaching /*开启注解缓存*/
@SpringBootApplication
public class CacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheRedisApplication.class, args);
    }
}
