package com.zhezhuo.web.home.module.screen.wechat;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.web.home.module.screen.BaseScreen;

/**
 * Created by jueshi on 15/12/15.
 */
public class AccessToken extends BaseScreen {

    public void execute() {
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("access_token", "");

        super.convertJsonP(jsonObject.toJSONString(), null);
    }
}
