package com.dwheng.lovehelper.controller;

import com.dwheng.lovehelper.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@RestController
@RequestMapping("api/greeting")
public class GreetingController {

    @Resource
    GreetingService greetingService;

    @GetMapping(value = "/zaoan")
    public Object zaoan() {
        greetingService.greetingZaoan();
        return null;
    }

    @GetMapping(value = "/wanan")
    public Object wanan() {
        greetingService.greetingWanan();
        return null;
    }

    @GetMapping(value = "/xiaban")
    public Object xiaban() {
        greetingService.greetingXiaban();
        return null;
    }
}
