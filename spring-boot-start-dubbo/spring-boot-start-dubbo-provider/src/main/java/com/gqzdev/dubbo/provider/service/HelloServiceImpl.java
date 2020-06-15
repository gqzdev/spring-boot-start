package com.gqzdev.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gqzdev.dubbo.common.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * HelloServiceImpl
 *
 * @Author: ganquanzhong
 * @Date:  2020/6/15 13:25
 */

@Service
@Component
@Slf4j
public class HelloServiceImpl implements HelloService {
    /**
     * 问好
     *
     * @param name 姓名
     * @return 问好
     */
    @Override
    public String sayHello(String name) {
        log.info("someone is calling me......");
        return "say hello to: " + name;
    }
}
