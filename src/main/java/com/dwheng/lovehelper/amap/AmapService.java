package com.dwheng.lovehelper.amap;

import com.alibaba.fastjson.JSONObject;
import com.dwheng.lovehelper.utils.OkHttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dwh
 **/
@Service
@Slf4j
public class AmapService {

    @Resource
    AmapConfig amapConfig;

    public JSONObject getWeather() {
        String url = amapConfig.getWeatherUrl() +
                "?key=" + amapConfig.getKey() +
                "&city=" + amapConfig.getCity();
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                JSONObject lives = jsonObject.getJSONArray("lives").getJSONObject(0);
                return lives;
            }
        } catch (Exception e) {
            log.error("天气获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }
}
