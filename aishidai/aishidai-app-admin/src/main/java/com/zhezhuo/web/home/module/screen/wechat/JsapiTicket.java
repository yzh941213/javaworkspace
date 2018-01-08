package com.zhezhuo.web.home.module.screen.wechat;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.web.home.module.screen.BaseScreen;

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
