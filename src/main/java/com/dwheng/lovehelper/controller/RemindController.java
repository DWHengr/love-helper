package com.dwheng.lovehelper.controller;

import com.alibaba.fastjson.JSONObject;
import com.dwheng.lovehelper.amap.AmapService;
import com.dwheng.lovehelper.service.RemindService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@RestController
@RequestMapping("api/remind")
public class RemindController {

    @Resource
    RemindService remindService;

    @Resource
    AmapService amapService;

    @GetMapping(value = "/drinkwater")
    public Object token() {
        remindService.remindDrinkWater("记得要喝水~");
        return amapService.getWeather();
    }
}
