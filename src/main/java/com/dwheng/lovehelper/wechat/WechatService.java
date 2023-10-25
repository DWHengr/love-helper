package com.dwheng.lovehelper.wechat;

import com.alibaba.fastjson.JSONObject;
import com.dwheng.lovehelper.utils.OkHttpUtils;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Service
@Slf4j
public class WechatService {
    @Resource
    WeChatConfig weChatConfig;

    @Resource
    Cache<String, String> caffeineCache;

    /**
     * 获取微信token
     *
     * @return
     */
    public String getWechatToken() {
        //先从缓存中获取
        String access_token = caffeineCache.asMap().get("access_token");
        if (StringUtils.isNotEmpty(access_token))
            return access_token;
        String url = weChatConfig.getGetAccessTokenUrl() +
                "?grant_type=client_credential" +
                "&appid=" + weChatConfig.getAppid() +
                "&secret=" + weChatConfig.getSecret();
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                access_token = jsonObject.getString("access_token");
                if (StringUtils.isNotEmpty(access_token)) {
                    caffeineCache.put("access_token", access_token);
                    return access_token;
                }
            }
        } catch (Exception e) {
            log.error("token获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }

    public void sendTemplateMsg(String token, WechatTemplateMsg msg) {
        String url = weChatConfig.getSendTemplateMsgUrl() +
                "?access_token=" + token;
        try {
            String response = OkHttpUtils.postResponseWithParamsInJson(url, JSONObject.toJSONString(msg));
            log.info("response ---> {}", response);
        } catch (Exception e) {
            log.error("token获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
    }
}
