package com.dwheng.lovehelper.service;

import com.alibaba.fastjson.JSONObject;
import com.dwheng.lovehelper.amap.AmapService;
import com.dwheng.lovehelper.tian.TianService;
import com.dwheng.lovehelper.wechat.WeChatConfig;
import com.dwheng.lovehelper.wechat.WechatService;
import com.dwheng.lovehelper.wechat.WechatTemplateMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Service
@Slf4j
public class GreetingService {

    @Resource
    WeChatConfig weChatConfig;

    @Resource
    WechatService wechatService;

    @Resource
    AmapService amapService;

    @Resource
    TianService tianService;

    public void greetingZaoan() {
        String drinkWaterTemplateId = weChatConfig.getZaoanTemplateId();
        JSONObject weatherJson = amapService.getWeather();
        WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg(drinkWaterTemplateId)
                .addData("msg", tianService.getZaoan())
                .addData("city", weatherJson.getString("city"))
                .addData("weather", weatherJson.getString("weather"))
                .addData("temperature", weatherJson.getString("temperature"))
                .addData("humidity", weatherJson.getString("humidity"))
                .addData("windpower", weatherJson.getString("windpower"));
        wechatService.sendTemplateMsgToAllUser(wechatTemplateMsg);
    }

    public void greetingWanan() {
        String drinkWaterTemplateId = weChatConfig.getWananTemplateId();
        JSONObject weatherJson = amapService.getWeather();
        WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg(drinkWaterTemplateId)
                .addData("msg", tianService.getWanan())
                .addData("city", weatherJson.getString("city"))
                .addData("weather", weatherJson.getString("weather"))
                .addData("temperature", weatherJson.getString("temperature"))
                .addData("humidity", weatherJson.getString("humidity"))
                .addData("windpower", weatherJson.getString("windpower"));
        wechatService.sendTemplateMsgToAllUser(wechatTemplateMsg);
    }

    public void greetingXiaban() {
        String drinkWaterTemplateId = weChatConfig.getXiabanTemplateId();
        JSONObject weatherJson = amapService.getWeather();
        WechatTemplateMsg wechatTemplateMsg = new WechatTemplateMsg(drinkWaterTemplateId)
                .addData("msg", "下班、下班~")
                .addData("city", weatherJson.getString("city"))
                .addData("weather", weatherJson.getString("weather"))
                .addData("temperature", weatherJson.getString("temperature"))
                .addData("humidity", weatherJson.getString("humidity"))
                .addData("windpower", weatherJson.getString("windpower"))
                .addData("one", tianService.getOne());
        wechatService.sendTemplateMsgToAllUser(wechatTemplateMsg);
    }
}
