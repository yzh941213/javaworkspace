package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.ResourceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.entity.SysUsersRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/22.
 */
@Controller
@RequestMapping("/manager/resource")
public class ResourceController {

    @Autowired
    ResourceManager resourceManager;


    @RequestMapping("/query.do")
    @ResponseBody
    public String addRoleDO() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        List<SysUsersRoleDO> list = null;
        Result<List<ResourceDO>> result = resourceManager.queryAllResource();
    System.out.println("========"+result);
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", "查询失败");
        return jsonObject.toString();
    }



}
