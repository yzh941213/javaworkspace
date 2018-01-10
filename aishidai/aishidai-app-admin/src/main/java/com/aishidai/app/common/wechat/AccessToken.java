package com.aishidai.app.common.wechat;

import com.aishidai.app.common.BaseScreen;
import com.alibaba.fastjson.JSONObject;

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
