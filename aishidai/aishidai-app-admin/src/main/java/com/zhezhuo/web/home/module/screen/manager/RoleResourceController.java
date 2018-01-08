package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.dao.RoleDAO;
import com.zhezhuo.biz.manager.ResourceManager;
import com.zhezhuo.biz.manager.RoleManager;
import com.zhezhuo.biz.manager.RoleResourceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ResourceDO;
import com.zhezhuo.model.entity.RoleResourceDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/manager/role")
public class RoleResourceController {

    @Autowired
    RoleResourceManager roleResourceManager;

    @Autowired
    ResourceManager resourceManager;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    RoleManager roleManager;

    @RequestMapping(value = {"/resource/add.do", "/resource/edit.do"})
    @ResponseBody
    public String addRoleDO(@RequestParam(value = "data", defaultValue = "")String data) {
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
            result = roleResourceManager.addRoleResourceDO(list);
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

    @RequestMapping("/resource/query.do")
    @ResponseBody
    public String queryResourceDO(@RequestParam(value = "roleId", defaultValue = "")long roleId) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<List<ResourceDO>> result  = resourceManager.queryAllResourceByRoleId(roleId);

        if (result != null && result.isSuccess()) {
            jsonObject.put("role", roleDAO.queryRoleById(roleId));
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
