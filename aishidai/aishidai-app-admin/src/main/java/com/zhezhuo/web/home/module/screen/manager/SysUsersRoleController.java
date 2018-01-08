package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.SysUsersRoleManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.SysUsersRoleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/22.
 */
@Controller
@RequestMapping("/manager/sysusers")
public class SysUsersRoleController {

    @Autowired
    SysUsersRoleManager sysUsersRoleManager;


    @RequestMapping("/role/add.do")
    @ResponseBody
    public String addRoleDO(@RequestParam(value = "data", defaultValue = "") String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        List<SysUsersRoleDO> list = null;
        try {
            list = JSONArray.parseArray(data, SysUsersRoleDO.class);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("message", "参数错误");
            jsonObject.put("data", -1);
            return jsonObject.toString();
        }
        if (list == null || list.isEmpty()) {
            jsonObject.put("message", "参数错误");
            jsonObject.put("data", -1);
            return jsonObject.toString();
        }
        Result<Long> result = null;
        try {
            result = sysUsersRoleManager.addSysUsersRole(list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", "添加失败");
            return jsonObject.toString();
        }
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", "添加失败");
        return jsonObject.toString();
    }

    @RequestMapping("/role/query.do")
    @ResponseBody
    public String addRoleDO(@RequestParam(value = "userId") long userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<List<SysUsersRoleDO>> result = sysUsersRoleManager.querySysUsersRole(userId);
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }

        jsonObject.put("data", "");
        jsonObject.put("message", "添加失败");
        return jsonObject.toString();
    }

}
