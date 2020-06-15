package com.gqzdev.cache.redis.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName MyCacheConfig
 * @Description  配置自己的Cache中key生成策略
 * @Author ganquanzhong
 * @Date2019/10/13 22:53
 * @Version
 **/

@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator myKeyGenerator(){

        return new KeyGenerator(){
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+"["+ Arrays.asList(params) +"+]";
            }
        };
    }
}
