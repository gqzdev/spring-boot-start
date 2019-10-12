package com.gqz.springbootcache.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SpringUtils
 * @author: ganquanzhong
 * @date: 2019/10/11 15:34
 */


@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    /*
     *实现了ApplicationContextAware接口的类，
     * 在Spring容器加载的时候会自动执行ApplicationContextWare中的setApplicationContext。
     * 即自动注入ApplicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext args) throws BeansException {
        applicationContext=args;
    }

    public static Object getObject(String beanName){
        Object bean = applicationContext.getBean(beanName);
        return bean;
    }

    //获取ApplicationContext
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
