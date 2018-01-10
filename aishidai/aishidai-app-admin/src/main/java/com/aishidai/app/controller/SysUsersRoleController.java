package com.aishidai.app.controller;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.model.pojo.SysusersRoleDO;
import com.aishidai.app.service.SysUsersRoleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/manage/sysusers/role")
public class SysUsersRoleController {

    @Autowired
    private SysUsersRoleService sysUsersRoleService;


    @RequestMapping("/add.do")
    @ResponseBody
    public String addUserRoleDO(
    		@RequestParam(value = "data", defaultValue = "") String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        List<SysusersRoleDO> list = null;
        try {
            list = JSONArray.parseArray(data, SysusersRoleDO.class);
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
            result = sysUsersRoleService.addSysUsersRole(list);
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
    
    @RequestMapping("/edit.do")
    @ResponseBody
    public String editUserRoleDO(@RequestParam(value = "data", defaultValue = "") String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        List<SysusersRoleDO> list = null;
        try {
            list = JSONArray.parseArray(data, SysusersRoleDO.class);
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
            result = sysUsersRoleService.editSysUsersRole(list);
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
    
    @RequestMapping("/queryList.do")
    @ResponseBody
    public String addRoleDO(@RequestParam(value = "userId") long userId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<List<SysusersRoleDO>> result = sysUsersRoleService.querySysUsersRole(userId);
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
