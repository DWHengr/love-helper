package com.dwheng.lovehelper.wechat;

import com.dwheng.lovehelper.utils.OkHttpUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Service
public class WechatService {
    @Resource
    WeChatConfig weChatConfig;

    /**
     * 获取微信token
     *
     * @return
     */
    public String getWechatToken() {
        String url = weChatConfig.getGetAccessTokenUrl() +
                "?grant_type=client_credential" +
                "&appid=" + weChatConfig.getAppid() +
                "&secret=" + weChatConfig.getSecret();
        String response = OkHttpUtils.getResponse(url);
        return response;
    }
}
