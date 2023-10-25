package com.dwheng.lovehelper.amap;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: dwh
 **/
@Data
@Component
@ConfigurationProperties(prefix = "amap")
public class AmapConfig {
    private String key;
    private String city;
    private String weatherUrl;
}
