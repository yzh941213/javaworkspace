package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.AnnounceManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AnnounceDO;
import com.zhezhuo.model.query.AnnounceQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/21.
 */
@Controller
@RequestMapping("/manager/anno")
public class AnnounceController {


    @Autowired
    AnnounceManager announceManager;

    @RequestMapping("/list.do")
    @ResponseBody
    public String queryAnnounceDOList(@RequestParam(value = "keywords", defaultValue = "", required = false) String keywords,
                                  @RequestParam(value = "userId", defaultValue = "0", required = false) long userId,
                                  @RequestParam(value = "aoData") String aoData,
                                  @RequestParam(value = "sort", defaultValue = "anId", required = false) String sort,
                                  @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
                                  @RequestParam(value = "status", defaultValue = "0", required = false) int status) {

        JSONArray jsonarray = JSONArray.parseArray(aoData);
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
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

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("pageSize", iDisplayLength);
        jsonObject.put("sEcho", sEcho);
        jsonObject.put("success", false);

        AnnounceQuery query = new AnnounceQuery();
        query.setOrder(order);
        query.setSortField(sort);
        query.setStatuss(status);
        if (StringUtils.isNotBlank(keywords)) {
            query.setKeywords("%" + keywords + "%");
        }
        query.setUserId(userId);
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);

        Result<List<AnnounceDO>> result = announceManager.queryAnnounceList(query);

        if (result != null && result.isSuccess()) {
            jsonObject.put("iTotalRecords", query.getTotalItem()); //实际的行数
            jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); //显示的行数,这个要和上面
            jsonObject.put("aaData", result.getResult());
            jsonObject.put("message", "query success");
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("iTotalRecords", 0); //实际的行数
        jsonObject.put("iTotalDisplayRecords", 0); //显示的行数,这个要和上面
        jsonObject.put("aaData", "");
        jsonObject.put("message", "query failed");

        return jsonObject.toString();
    }


    @RequestMapping("/detail.do")
    @ResponseBody
    public String queryAnnounceDO(@RequestParam(value = "annoId") int annoId) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<AnnounceDO> result = announceManager.queryAnnounceInfo(annoId);

        if (result != null && result.isSuccess()) {
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", "query success");
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("data", "");
        jsonObject.put("message", "query failed");

        return jsonObject.toString();
    }

    @RequestMapping(value = {"/edit.do", "/save.do"})
    @ResponseBody
    public String editAnnounceDO(@RequestParam(value = "annoId", defaultValue = "0", required = false) long annoId,
                                 @RequestParam(value = "userId",defaultValue = "-0", required = false) long userId,
                                 @RequestParam(value = "title",defaultValue = "", required = false) String title,
                                 @RequestParam(value = "subtitle",defaultValue = "", required = false) String subtitle,
                                 @RequestParam(value = "image",defaultValue = "", required = false) String image,
                                 @RequestParam(value = "summary",defaultValue = "", required = false) String summary) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        AnnounceDO announceDO = new AnnounceDO();
        announceDO.setAnId(annoId);
        announceDO.setUserId(userId);
        announceDO.setTitle(title);
        announceDO.setSubtitle(subtitle);
        announceDO.setImage(image);
        announceDO.setSummary(summary);

        Result<Long> result = announceManager.editAnnounceDO(announceDO);
        if (result != null && result.isSuccess()) {
            jsonObject.put("annoId", result.getResult());
            jsonObject.put("message", "query success");
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("annoId", -1);
        jsonObject.put("message", "query failed");

        return jsonObject.toString();
    }


    @RequestMapping("/del.do")
    @ResponseBody
    public String deleteAnnounceDO(@RequestParam(value = "annoId") int annoId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<Integer> result = announceManager.deleteAnnounceDO(annoId);
        if (result != null && result.isSuccess()) {
            jsonObject.put("message", "success");
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("aaData", "");
        jsonObject.put("message", "failed");

        return jsonObject.toString();
    }

}
