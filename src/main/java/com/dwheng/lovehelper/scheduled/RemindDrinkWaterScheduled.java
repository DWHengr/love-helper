package com.dwheng.lovehelper.scheduled;

import com.dwheng.lovehelper.service.RemindService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Component
public class RemindDrinkWaterScheduled {

    @Resource
    RemindService remindService;

    @Scheduled(cron = "0 40 7 * * ?")
    public void remindWater1() {
        remindService.remindDrinkWater("早上7:40：喝第1杯水（清理肠胃~）");
    }

    @Scheduled(cron = "0 30 8 * * ?")
    public void remindWater2() {
        remindService.remindDrinkWater("早上8:30：喝第2杯水（提高活力~）");
    }

    @Scheduled(cron = "0 0 11 * * ?")
    public void remindWater3() {
        remindService.remindDrinkWater("上午11:00：喝第3杯水（增加饱腹~）");
    }

    @Scheduled(cron = "0 0 13 * * ?")
    public void remindWater4() {
        remindService.remindDrinkWater("中午13:00：喝第4杯水（促进消化~）");
    }

    @Scheduled(cron = "0 0 15 * * ?")
    public void remindWater5() {
        remindService.remindDrinkWater("下午15:00：喝第5杯水（提神醒脑~）");
    }

    @Scheduled(cron = "0 20 17 * * ?")
    public void remindWater6() {
        remindService.remindDrinkWater("下午5:20：喝第6杯水（减少疲劳,爱你哟~）");
    }

    @Scheduled(cron = "0 0 19 * * ?")
    public void remindWater7() {
        remindService.remindDrinkWater("晚上19:00：喝第7杯水（解毒排泄~）");
    }

    @Scheduled(cron = "0 0 21 * * ?")
    public void remindWater9() {
        remindService.remindDrinkWater("晚上21:00：喝第8杯水（预防血稠~）");
    }
}
