package com.aishidai.app.common.wechat;

import com.aishidai.app.common.BaseScreen;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by jueshi on 15/12/15.
 */
public class JsapiTicket extends BaseScreen{

    public void execute() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        jsonObject.put("ticket", "bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA");

        jsonObject.put("success", true);

        super.convertJsonP(jsonObject.toJSONString(), null);
    }

}
