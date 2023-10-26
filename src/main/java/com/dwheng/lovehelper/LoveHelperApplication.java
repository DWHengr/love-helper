package com.dwheng.lovehelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoveHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoveHelperApplication.class, args);
    }

}
