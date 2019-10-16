package com.gqz.springbootcache.config;

import com.gqz.springbootcache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @ClassName: MyRedisConfig
 * @author: ganquanzhong
 * @date: 2019/10/16 16:12
 */

@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)throws UnknownHostException {
        RedisTemplate<Object,Employee> template = new RedisTemplate<Object,Employee>();

        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> ser = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(ser);
        return template;

    }

    //替换自动注入的RedisCacheManger
    //CacheManagerCustomizers可以用来定制缓存的一些规则
    /*@Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);

        return cacheManager;

    }*/
}
