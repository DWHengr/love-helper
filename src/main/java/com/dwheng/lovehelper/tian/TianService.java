package com.dwheng.lovehelper.tian;

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
public class TianService {

    @Resource
    TianConfig tianConfig;

    public String getDujitang() {
        String url = tianConfig.getDujitangUrl() +
                "?key=" + tianConfig.getKey();
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                String caihongpi = jsonObject.getJSONObject("result").getString("content");
                return caihongpi;
            }
        } catch (Exception e) {
            log.error("彩虹屁获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }

    public String getZaoan() {
        String url = tianConfig.getZaoanUrl() +
                "?key=" + tianConfig.getKey();
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                String caihongpi = jsonObject.getJSONObject("result").getString("content");
                return caihongpi;
            }
        } catch (Exception e) {
            log.error("早安获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }

    public String getWanan() {
        String url = tianConfig.getWananUrl() +
                "?key=" + tianConfig.getKey();
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                String caihongpi = jsonObject.getJSONObject("result").getString("content");
                return caihongpi;
            }
        } catch (Exception e) {
            log.error("晚安获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }

    public String getOne() {
        String url = tianConfig.getOneUrl() +
                "?key=" + tianConfig.getKey();
        try {
            String response = OkHttpUtils.getResponse(url);
            JSONObject jsonObject = JSONObject.parseObject(response);
            if (null != jsonObject) {
                String caihongpi = jsonObject.getJSONObject("result").getString("word");
                return caihongpi;
            }
        } catch (Exception e) {
            log.error("晚安获取失败:{} {}", e.getMessage(), e.getStackTrace());
        }
        return null;
    }


}
