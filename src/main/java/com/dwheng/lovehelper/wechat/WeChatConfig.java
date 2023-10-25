package com.dwheng.lovehelper.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: dwh
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeChatConfig {
    private String appid;
    private String secret;
    private String getAccessTokenUrl;
    private String sendTemplateMsgUrl;
}
