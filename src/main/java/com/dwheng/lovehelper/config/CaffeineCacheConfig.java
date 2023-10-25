package com.dwheng.lovehelper.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author: dwh
 **/
@Configuration
public class CaffeineCacheConfig {
    private final long token_expire_time = 7000;

    @Bean
    public Cache<String, String> caffeineCache() {
        return Caffeine.newBuilder()
                // 设置最后一次写入后经过固定时间过期
                .expireAfterWrite(token_expire_time, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(10)
                // 缓存的最大条数
                .maximumSize(10)
                .build();
    }
}
