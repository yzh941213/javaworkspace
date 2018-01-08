package com.zhezhuo.web.home.module.screen.wechat;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.web.home.module.screen.BaseScreen;

/**
 * Created by jueshi on 15/12/23.
 */
public class Signature extends BaseScreen{
    public void execute() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("signature", "0f9de62fce790f9a083d5c99e95740ceb90c27ed");
        jsonObject.put("nonceStr", "Wm3WZYTPz0wzccnW");
        jsonObject.put("timestamp", "1414587457");
        jsonObject.put("success", true);
        super.convertJsonP(jsonObject.toJSONString(), null);
    }
}
