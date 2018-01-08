package com.zhezhuo.web.home.module.screen.manager;

/**
 * Created by 蝈蝈 on 2016/11/18.
 */

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by 蝈蝈 on 2016/11/2.
 */
@Controller
@RequestMapping("/manager")
public class ExpressQueryController {


    @RequestMapping(value = {"/express.do"})
    @ResponseBody
    public String queryExpress(@RequestParam("number") String number,
                               @RequestParam(value = "type", defaultValue = "auto") String type) {

        JSONObject object = new JSONObject();
        object.put("success", false);

        String host = "http://jisukdcx.market.alicloudapi.com";
        String path = "/express/query";
        String method = "GET";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE b35496fe3afb4eda9c70255c498e8c68");
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("number", number);
        querys.put("type", type);
        HttpResponse response = null;
        try {
            response = HttpUtils.doGet(host, path, method, headers, querys);
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
