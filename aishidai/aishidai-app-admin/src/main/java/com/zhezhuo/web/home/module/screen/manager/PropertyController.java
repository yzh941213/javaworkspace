package com.zhezhuo.web.home.module.screen.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.PropertyManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.PropertyDO;
import com.zhezhuo.model.query.PropertyQuery;

/**
 * Created by 蝈蝈 on 2016/8/18.
 */
@Controller
@RequestMapping("/manager/property")
public class PropertyController {

    @Autowired
    private PropertyManager propertyManager;

    /**
     * 分页获取数据
     * @param parentId 类别
     * @param aoData 分页信息
     * @return jsonArray.toString()
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public String queryPropertyDOList(@RequestParam("parentId")long parentId,
                                      @RequestParam(value = "aoData", defaultValue = "", required = false)String aoData) {
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
        String sEcho = "";
        if (!aoData.equals("")) {
            JSONArray jsonarray = JSONArray.parseArray(aoData);
            for (int i = 0; i < jsonarray.size(); i++) {
                JSONObject obj = (JSONObject) jsonarray.get(i);
                if (obj.get("name").equals("sEcho")) {
                    sEcho = obj.get("value").toString();
                }
                if (obj.get("name").equals("iDisplayStart")) {
                    iDisplayStart = obj.getIntValue("value");
                }
                if (obj.get("name").equals("iDisplayLength")) {
                    iDisplayLength = obj.getIntValue("value");
                }
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageSize", iDisplayLength);
        jsonObject.put("sEcho", sEcho);
        jsonObject.put("success", false);

        PropertyQuery query = new PropertyQuery();
        query.setParentId(parentId);
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);

        Result<List<PropertyDO>> result = propertyManager.queryPropertyDOList(query);
        return returnString(result, jsonObject, query);
    }

    /**
     * 详情接口
     * @param propertyId id
     * @return jsonObject
     */
    @RequestMapping("/detail.do")
    @ResponseBody
    public String queryPropertyDOById(@RequestParam("propertyId")long propertyId) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<PropertyDO> result = propertyManager.queryPropertyDOById(propertyId);
        if (result == null || !result.isSuccess() || result.getResult() == null) {
            jsonObject.put("message", "查询失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", JSONObject.toJSON(result.getResult()));

        return jsonObject.toString();
    }

    /**
     * 状态操作(-1删除....)
     * @param propertyId id
     * @param status 状态
     * @return jsonObject
     */
    @RequestMapping(value = {"/status.do", "/size/del.do","/age/del.do","/color/del.do","/title/del.do"})
    @ResponseBody
    public String updatePropertyDO(@RequestParam("propertyId")long propertyId,
                                   @RequestParam("status")int status) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        PropertyDO propertyDO = new PropertyDO();
        propertyDO.setPropertyId(propertyId);
        propertyDO.setStatus(status);
        Result<Integer> result = propertyManager.updatePropertyDOStatus(propertyDO);

        if (result == null || !result.isSuccess() || result.getResult() <= 0) {
            jsonObject.put("message", "操作失败");
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "操作成功");
        return jsonObject.toString();
    }

    /**
     * 编辑接口(insert or update)
     * @param propertyId id 根据id是否为0判断是insert or update
     * @param proName 名称
     * @param imgPath 图片路径
     * @param description 描述
     * @param parentId 上级id
     * @param alias 上级名称
     * @param feature 扩展字段
     * @return jsonobject
     */
    @RequestMapping(value = {"/edit.do", "/size/save.do", "/size/edit.do", "/color/edit.do", "/color/save.do", "/age/save.do", "/age/edit.do"})
    @ResponseBody
    public String editPropertyDO(@RequestParam(value = "propertyId", defaultValue = "0",required=false)long propertyId,
                                 @RequestParam(value = "proName")String proName,
                                 @RequestParam(value = "imgPath", defaultValue = "",required=false)String imgPath,
                                 @RequestParam(value = "description",required=false)String description,
                                 @RequestParam(value = "parentId")long parentId,
                                 @RequestParam(value = "alias",required=false)String alias,
                                 @RequestParam(value = "feature", defaultValue = "", required = false)String feature) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        PropertyDO propertyDO = new PropertyDO();
        propertyDO.setPropertyId(propertyId);
        propertyDO.setProName(proName);
        propertyDO.setImgPath(imgPath);
        propertyDO.setDescription(description);
        propertyDO.setParentId(parentId);
        propertyDO.setAlias(alias);
        propertyDO.setFeature(feature);

        Result<Long> result = propertyManager.editPropertyDO(propertyDO);
        if (result == null || !result.isSuccess() || result.getResult() <= 0) {
            jsonObject.put("message", "操作失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "操作成功");
        return jsonObject.toString();
    }


    public String  returnString(Result<List<PropertyDO>> result,
                                JSONObject jsonObject, PropertyQuery query) {
        if (result != null && result.isSuccess()) {
            List<PropertyDO> itemDOList = result.getResult();
            JSONArray itemList = new JSONArray();
            for (PropertyDO propertyDO : itemDOList) {
                JSONObject item = new JSONObject();

                item.put("propertyId", propertyDO.getPropertyId());
                item.put("proName", propertyDO.getProName());
                item.put("imgPath", propertyDO.getImgPath());
                item.put("description", propertyDO.getDescription());
                item.put("parentId", propertyDO.getParentId());
                item.put("alias", propertyDO.getAlias());
                item.put("feature", propertyDO.getFeature());
                itemList.add(item);
            }
            jsonObject.put("iTotalRecords", query.getTotalItem()); //实际的行数
            jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); //显示的行数,这个要和上面
            jsonObject.put("aaData", itemList);
            jsonObject.put("success", true);
        } else {
            jsonObject.put("message", "找不到宝贝");
        }
        return jsonObject.toString();
    }
    
    
    @RequestMapping("/child.do")
    @ResponseBody
    public String queryPropertyDOByParentId(@RequestParam(value = "parentId")long parentId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<List<PropertyDO>> result = propertyManager.queryPropertyDOByParentId(parentId);
        if (result == null || !result.isSuccess()) {
            jsonObject.put("message", "查询失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "成功");
        jsonObject.put("data", JSONArray.toJSON(result.getResult()));
        return jsonObject.toString();
    }
    
}
