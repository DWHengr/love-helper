package com.dwheng.lovehelper.wechat;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: dwh
 **/
@Data
public class WechatTemplateMsg {
    private String touser;
    private String template_id;
    private String topcolor;
    private JSONObject data;

    @Data
    @AllArgsConstructor
    public static class MsgData {
        private String value;
        private String color;

        public MsgData(String value) {
            this.value = value;
            this.color = "#173177";
        }
    }

    public WechatTemplateMsg(String template_id) {
        this.touser = "OPENID";
        this.template_id = template_id;
        this.topcolor = "#FF0000";
        this.data = new JSONObject();
    }

    public WechatTemplateMsg addData(String key, MsgData msgData) {
        data.put(key, msgData);
        return this;
    }

    public WechatTemplateMsg addData(String key, String value) {
        data.put(key, new MsgData(value));
        return this;
    }
}

