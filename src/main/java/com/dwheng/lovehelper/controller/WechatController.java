package com.dwheng.lovehelper.controller;

import com.dwheng.lovehelper.wechat.WechatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@RestController
@RequestMapping("/api/wechat")
public class WechatController {

    @Resource
    WechatService wechatService;

    @GetMapping(value = "/token/get")
    public String token() {
        return wechatService.getWechatToken();
    }

    @GetMapping(value = "/userlist/get")
    public Object userlist() {
        String wechatToken = wechatService.getWechatToken();
        return wechatService.getUserList(wechatToken);
    }
}
