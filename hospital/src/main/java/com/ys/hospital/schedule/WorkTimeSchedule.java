package com.ys.hospital.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-12 11:21
 **/

@Component
public class WorkTimeSchedule {
    @Scheduled(cron = ("0 0 0 * * 1-7"))
    public void work() {
        System.out.println("该睡觉了");
    }
}
