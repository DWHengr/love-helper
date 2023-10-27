package com.dwheng.lovehelper.wechat;

import com.alibaba.fastjson.JSONArray;
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
    Cache<String, Object> caffeineCache;

    /**
     * 获取微信token
     *
     * @return
     */
    public String getWechatToken() {
        //先从缓存中获取
        String access_token = (String) caffeineCache.asMap().get("access_token");
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

    /**
     * 获取关注的用户列表
     *
     * @param token
     */
    public JSONArray getUserList(String token) {
        JSONArray userList = (JSONArray) caffeineCache.asMap().get("user_list");
        if (null != userList)
            return userList;
        String url = weChatConfig.getGetUserList() +
                "?access_token=" + token +
                "&next_openid=";
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                userList = jsonObject.getJSONObject("data").getJSONArray("openid");
                if (null != userList) {
                    caffeineCache.put("user_list", userList);
                    return userList;
                }
            }
        } catch (Exception e) {
            log.error("UserList获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }

    /**
     * 根据模板发送消息
     *
     * @param token
     * @param msg
     */
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

    /**
     * 根据模板发送消息给指定用户
     *
     * @param msg
     */
    public void sendTemplateMsgToUser(WechatTemplateMsg msg, String user) {
        String token = getWechatToken();
        String url = weChatConfig.getSendTemplateMsgUrl() +
                "?access_token=" + token;
        try {
            msg.setTouser(user);
            log.info(JSONObject.toJSONString(msg));
            String response = OkHttpUtils.postResponseWithParamsInJson(url, JSONObject.toJSONString(msg));
            log.info("response ---> {}", response);
        } catch (Exception e) {
            log.error("token获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }

    }

    /**
     * 根据模板发送消息给所以用户
     *
     * @param msg
     */
    public void sendTemplateMsgToAllUser(WechatTemplateMsg msg) {
        String token = getWechatToken();
        JSONArray userList = getUserList(token);
        for (Object user : userList) {
            String url = weChatConfig.getSendTemplateMsgUrl() +
                    "?access_token=" + token;
            try {
                msg.setTouser((String) user);
                log.info(JSONObject.toJSONString(msg));
                String response = OkHttpUtils.postResponseWithParamsInJson(url, JSONObject.toJSONString(msg));
                log.info("response ---> {}", response);
            } catch (Exception e) {
                log.error("token获取失败:{} {}", e.getMessage(), e.getStackTrace());
            }
        }
    }
}
