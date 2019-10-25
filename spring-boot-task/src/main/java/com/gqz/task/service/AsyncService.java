package com.gqz.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static java.lang.Thread.sleep;

/**
 * @ClassName: AsyncService
 * @author: ganquanzhong
 * @date: 2019/10/25 15:13
 */

@Service
public class AsyncService {

    @Async  //标注为异步方法  多线程执行  需要使用@EnableAsync开始异步任务的注解
    public void hello(){
        try {
            //休眠3秒
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello world！ async异步任务");
    }

}
