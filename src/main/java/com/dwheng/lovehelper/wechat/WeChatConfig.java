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
    private String getUserList;
    private String sendTemplateMsgUrl;
    private String drinkWaterTemplateId;
    private String zaoanTemplateId;
    private String xiabanTemplateId;
    private String wananTemplateId;
}
