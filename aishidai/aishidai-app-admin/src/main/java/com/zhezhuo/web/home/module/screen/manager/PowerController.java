package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 蝈蝈 on 2016/12/1.
 */
@Controller
@RequestMapping("/power")
public class PowerController {

    @RequestMapping("/failed.do")
    @ResponseBody
    public String checkedFailed(){
        JSONObject object = new JSONObject();
        object.put("success", false);
        object.put("message", "没有权限");
        object.put("data","");
        return object.toString();
    }

}
