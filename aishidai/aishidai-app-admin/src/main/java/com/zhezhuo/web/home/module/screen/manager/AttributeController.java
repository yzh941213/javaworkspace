package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.dao.AttributeDAO;
import com.zhezhuo.biz.manager.AttributeManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AttributeDO;
import com.zhezhuo.model.query.AttributeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/17.
 */
@Controller
@RequestMapping("/manager/attribute")
public class AttributeController {

    @Autowired
    AttributeManager attributeManager;

    @Autowired
    AttributeDAO attributeDAO;

    /**
     * 商品特征列表(类别、场合......).
     * @param flag 区分
     * @return string
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public String queryAttributes(@RequestParam(value = "flag")long flag,
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

        AttributeQuery query = new AttributeQuery();
        query.setFlag(flag);
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);

        Result<List<AttributeDO>> result = attributeManager.queryAttributeDOList(query);
        return returnString(result, jsonObject, query);
    }

    /**
     * 特征详情接口.
     * @param attributeId id
     * @return string
     */
    @RequestMapping("/detail.do")
    @ResponseBody
    public String queryAttributes(@RequestParam(value = "attributeId")long attributeId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<AttributeDO> result = attributeManager.queryAttributeDOById(attributeId);
        if (result == null || !result.isSuccess()) {
            jsonObject.put("message", "查询失败");
            return jsonObject.toString();
        }

        jsonObject.put("success", true);
        jsonObject.put("message", "成功");
        jsonObject.put("data", JSONObject.toJSON(result.getResult()));
        return jsonObject.toString();
    }

    /**
     *插入或更新接口
     * @param attributeId
     * @param attrName
     * @param alias
     * @param imgPath
     * @param description
     * @param parentId
     * @param hot
     * @param feature
     * @return string
     */
    @RequestMapping(value = {"/edit.do", "/occasion/edit.do", "/occasion/save.do" , "/category/save.do", "/category/edit.do"}, method = RequestMethod.POST)
    @ResponseBody
    public String editAttributeDO(@RequestParam(value = "attributeId", defaultValue = "0")long attributeId,
                                    @RequestParam(value = "attrName", defaultValue = "", required = false)String attrName,
                                    @RequestParam(value = "alias", defaultValue = "", required = false)String alias,
                                    @RequestParam(value = "imgPath", defaultValue = "", required = false)String imgPath,
                                    @RequestParam(value = "description", defaultValue = "", required = false)String description,
                                    @RequestParam(value = "parentId")long parentId,
                                    @RequestParam(value = "hot", defaultValue = "0", required = false)int hot,
                                    @RequestParam(value = "feature", defaultValue = "", required = false)String feature,
                                    @RequestParam(value = "flag")long flag) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        AttributeDO attributeDO = new AttributeDO();
        attributeDO.setAttributeId(attributeId);
        attributeDO.setAttrName(attrName);
        attributeDO.setAlias(alias);
        attributeDO.setImgPath(imgPath);
        attributeDO.setDescription(description);
        attributeDO.setParentId(parentId);
        attributeDO.setHot(hot);
        attributeDO.setFeature(feature);
        attributeDO.setFlag(flag);

        Result<Long> result = attributeManager.editAttributeDO(attributeDO);
        if (result == null || !result.isSuccess()) {
            jsonObject.put("message", "数据操作失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "数据更新成功");
        return jsonObject.toString();
    }

    /**
     * 更新记录状态(删除)
     * @param attributeId id
     * @param status 状态
     * @return success/fail
     */
    @RequestMapping(value = {"/status.do", "/occasion/del.do", "/category/del.do"}, method = RequestMethod.POST)
    @ResponseBody
    public String updateAttributeDOStatus(@RequestParam("attributeId")long attributeId,
                                          @RequestParam("status")int status) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        AttributeDO attributeDO = new AttributeDO();
        attributeDO.setAttributeId(attributeId);
        attributeDO.setStatus(status);

        Result<Integer> result = attributeManager.updateAttributeStatus(attributeDO);
        if (result == null || !result.isSuccess()) {
            jsonObject.put("message", "操作失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "操作成功");
        return jsonObject.toString();
    }

    @RequestMapping("/child.do")
    @ResponseBody
    public String queryAttributeDOByParentId(@RequestParam(value = "parentId")long parentId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<List<AttributeDO>> result = attributeManager.queryAttributeDOByParentId(parentId);
        if (result == null || !result.isSuccess()) {
            jsonObject.put("message", "查询失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "成功");
        jsonObject.put("data", JSONArray.toJSON(result.getResult()));
        return jsonObject.toString();

    }

    public String  returnString(Result<List<AttributeDO>> result,
                                JSONObject jsonObject, AttributeQuery query) {
        if (result != null && result.isSuccess()) {
            List<AttributeDO> itemDOList = result.getResult();
            JSONArray itemList = new JSONArray();
            for (AttributeDO attributeDO : itemDOList) {
                JSONObject item = new JSONObject();

                item.put("attributeId", attributeDO.getAttributeId());
                item.put("attrName", attributeDO.getAttrName());
                item.put("alias", attributeDO.getAlias());
                item.put("imgPath", attributeDO.getImgPath());
                item.put("description", attributeDO.getDescription());
                item.put("parentId", attributeDO.getParentId());
                item.put("created", attributeDO.getCreated());
                item.put("updated", attributeDO.getUpdated());
                item.put("hot", attributeDO.getHot());
                item.put("feature", attributeDO.getFeature());
                item.put("status", attributeDO.getStatus());

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
}
