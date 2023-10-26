package com.dwheng.lovehelper.service;

import com.alibaba.fastjson.JSONObject;
import com.dwheng.lovehelper.amap.AmapService;
import com.dwheng.lovehelper.wechat.WeChatConfig;
import com.dwheng.lovehelper.wechat.WechatService;
import com.dwheng.lovehelper.wechat.WechatTemplateMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Service
public class RemindService {

    @Resource
    WeChatConfig weChatConfig;

    @Resource
    WechatService wechatService;

    @Resource
    AmapService amapService;

    public void remindDrinkWater(String msg) {
        String drinkWaterTemplateId = weChatConfig.getDrinkWaterTemplateId();
        JSONObject weatherJson = amapService.getWeather();
        WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg(drinkWaterTemplateId)
                .addData("msg", msg)
                .addData("city", weatherJson.getString("city"))
                .addData("weather", weatherJson.getString("weather"))
                .addData("temperature", weatherJson.getString("temperature"))
                .addData("humidity", weatherJson.getString("humidity"))
                .addData("windpower", weatherJson.getString("windpower"));
        wechatService.sendTemplateMsgToAllUser(wechatTemplateMsg);
    }

}
