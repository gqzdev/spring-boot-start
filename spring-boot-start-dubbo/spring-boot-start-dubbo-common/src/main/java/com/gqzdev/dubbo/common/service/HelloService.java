package com.gqzdev.dubbo.common.service;

/**
 * Dubbo 中相同的接口
 *
 * @Author: ganquanzhong
 * @Date:  2020/6/15 13:17
 */

public interface HelloService {
    /**
     * 问好
     *
     * @param name 姓名
     * @return 问好
     */
    String sayHello(String name);
}
