package com.gqz.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: ScheduledService
 * @author: ganquanzhong
 * @date: 2019/10/25 15:35
 */


@Service
//@PropertySource("application.properties")
public class ScheduledService {

    /**
     * 表达式规则
     * second（秒）  minute（分） hour（时） day of month（日） month（月） day of week（周几）
     *
     * @author ganquanzhong
     * @date   2019/10/25 15:39
     */   
    //@Scheduled(cron = "0 * * * * MON-FRI")
    @Scheduled(cron = "${time.autoupdate.cron}")
    public void hello(){
        System.out.println("定时任务(Schedule)"+new Date());
    }
}
