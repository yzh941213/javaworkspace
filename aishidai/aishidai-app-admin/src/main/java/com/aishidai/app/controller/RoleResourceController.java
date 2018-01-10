package com.aishidai.app.controller;

import com.aishidai.app.model.custom.po.Result;
import com.aishidai.app.service.ResourceService;
import com.aishidai.app.service.RoleResourceService;
import com.aishidai.app.service.RoleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/manage/roleResource")
public class RoleResourceController {

    @Autowired
    private RoleResourceService roleResourceService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;
    

    @RequestMapping(value = {"/add.do"})
    @ResponseBody
    public String addRoleResource(
    		@RequestParam(value = "data", defaultValue = "")String data) {
    	System.out.println(data);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        List<RoleResourceDO> list = null;
        try {
            list = JSONArray.parseArray(data, RoleResourceDO.class);
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
            result = roleResourceService.addRoleResourceDO(list);
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
    
    @RequestMapping(value = {"/edit.do"})
    @ResponseBody
    public String EditRoleResource(@RequestParam(value = "data", defaultValue = "")String data) {
    	System.out.println(data);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        List<RoleResourceDO> list = null;
        try {
            list = JSONArray.parseArray(data, RoleResourceDO.class);
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
            result = roleResourceService.editRoleResourceDO(list);
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
    
    
    @RequestMapping("/resource/queryList.do")
    @ResponseBody
    public String queryResourceDO(
    		@RequestParam(value = "roleId", required = true)long roleId) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<List<ResourceDO>> result  = resourceService.queryAllResourceByRoleId(roleId);

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
