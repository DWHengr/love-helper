package com.dwheng.lovehelper.tian;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: dwh
 **/
@Data
@Component
@ConfigurationProperties(prefix = "tian")
public class TianConfig {
    private String key;
    private String dujitangUrl;
    private String zaoanUrl;
    private String wananUrl;
    private String oneUrl;
}
