package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.NoticeManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.NoticeDO;
import com.zhezhuo.model.entity.NoticeTypeDO;
import com.zhezhuo.model.query.NoticeQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/9/26.
 */
@Controller
@RequestMapping("/manager/notice")
public class NoticeController {

    @Autowired
    NoticeManager noticeManager;


    @RequestMapping("/list.do")
    @ResponseBody
    public String queryNoticeDOList(@RequestParam(value = "keywords", defaultValue = "", required = false) String keywords,
                                    @RequestParam(value = "userId", defaultValue = "0", required = false) long userId,
                                    @RequestParam(value = "noticeType", defaultValue = "0", required = false) long noticeType,
                                    @RequestParam(value = "receiveId", defaultValue = "-1", required = false) long receiveId,
                                    @RequestParam(value = "aoData") String aoData,
                                    @RequestParam(value = "sort", defaultValue = "noId", required = false) String sort,
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

        NoticeQuery query = new NoticeQuery();
        query.setOrder(order);
        query.setSortField(sort);
        query.setStatuss(status);
        query.setNoticeType(noticeType);
        query.setReceiveId(receiveId);
        if (StringUtils.isNotBlank(keywords)) {
            query.setKeywords("%" + keywords + "%");
        }
        query.setUserId(userId);
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);

        Result<List<NoticeDO>> result = noticeManager.queryNoticeList(query);
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
    public String queryNoticeDOList(@RequestParam(value = "noId") long noId) {


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<NoticeDO> result = noticeManager.queryNoticeDOById(noId);
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

    @RequestMapping("/del.do")
    @ResponseBody
    public String deleteNoticeDO(@RequestParam(value = "noId") int noId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<Long> result = noticeManager.delNoticeDOById(noId);
        if (result != null && result.isSuccess()) {
            jsonObject.put("message", "success");
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("data", -1);
        jsonObject.put("message", "failed");

        return jsonObject.toString();
    }

    @RequestMapping(value = {"/edit.do","/add.do"})
    @ResponseBody
    public String editNoticeDO(@RequestParam(value = "noId", defaultValue = "0", required = false) long noId,
                               @RequestParam(value = "userId", defaultValue = "-0", required = false) long userId,
                               @RequestParam(value = "title", defaultValue = "", required = false) String title,
                               @RequestParam(value = "receiveId", defaultValue = "0", required = false) long receiveId,
                               @RequestParam(value = "content", defaultValue = "", required = false) String content,
                               @RequestParam(value = "noticeType", defaultValue = "1", required = false) long noticeType,
                               @RequestParam(value = "isDeleted", defaultValue = "0", required = false) int isDeleted) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        NoticeDO noticeDO = new NoticeDO();
        noticeDO.setNoId(noId);
        noticeDO.setUserId(userId);
        noticeDO.setTitle(title);
        noticeDO.setContent(content);
        noticeDO.setIsDeleted(isDeleted);
        noticeDO.setNoticeType(noticeType);
        noticeDO.setReceiveId(receiveId);
        noticeDO.setCreated(System.currentTimeMillis() / 1000);
        noticeDO.setUpdated(System.currentTimeMillis() / 1000);

        Result<Long> result = noticeManager.addNoticeDO(noticeDO);
        if (result != null && result.isSuccess()) {
            jsonObject.put("noId", result.getResult());
            jsonObject.put("message", "operate success");
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("noId", -1);
        jsonObject.put("message", "operate failed");

        return jsonObject.toString();
    }

    @RequestMapping("/type/list.do")
    @ResponseBody
    public String queryNoticeTypeDOList() {


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);


        Result<List<NoticeTypeDO>> result = noticeManager.queryNoticeTypeList();
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


}
