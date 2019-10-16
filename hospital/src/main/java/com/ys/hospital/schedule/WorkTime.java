package com.ys.hospital.schedule;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-12 11:21
 **/
public class WorkTime {
    @Scheduled(cron = ("0 0 0 * * Mon-Sun"))
    public void work() {
        System.out.println("该睡觉了");
    }
}
