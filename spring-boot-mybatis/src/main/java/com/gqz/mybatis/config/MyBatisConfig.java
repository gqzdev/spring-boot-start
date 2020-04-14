package com.gqz.mybatis.config;


import org.apache.ibatis.session.Configuration;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * 配置MyBatis
 *
 * @ClassName: MyBatisConfig
 * @author: ganquanzhong
 * @date: 2019/9/30 17:09
 */

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };

    }
}
