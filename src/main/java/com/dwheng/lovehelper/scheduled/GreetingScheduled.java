package com.dwheng.lovehelper.scheduled;

import com.dwheng.lovehelper.service.GreetingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Component
public class GreetingScheduled {

    @Resource
    GreetingService greetingService;

    @Scheduled(cron = "0 30 7 * * ?")
    public void zaoan() {
        greetingService.greetingZaoan();
    }

    @Scheduled(cron = "0 29 5 * * ?")
    public void xiaban() {
        greetingService.greetingXiaban();
    }

    @Scheduled(cron = "0 30 22 * * ?")
    public void wanan() {
        greetingService.greetingWanan();
    }
}
