package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.AdviseManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.AdviseDO;
import com.zhezhuo.model.query.AdviseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/10/18.
 */
@Controller
@RequestMapping("/manager/advise")
public class AdviseController {

    @Autowired
    private AdviseManager adviseManager;

    @RequestMapping("/list.do")
    @ResponseBody
    public String queryItemDOList(@RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
                                  @RequestParam(value = "sort", defaultValue = "adviseId", required = false) String sort,
                                  @RequestParam(value = "order", defaultValue = "desc", required = false) String order) {

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

        AdviseQuery query = new AdviseQuery();
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);
        
        query.setSortField(sort);
        query.setOrder(order);
        Result<List<AdviseDO>> result = adviseManager.queryAdviseList(query);

        if (result != null && result.isSuccess()) {
            jsonObject.put("iTotalRecords", query.getTotalItem()); //实际的行数
            jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); //显示的行数,这个要和上面
            jsonObject.put("aaData", result.getResult());
            jsonObject.put("success", true);
            return jsonObject.toString();
        }
        jsonObject.put("iTotalRecords", 0); //实际的行数
        jsonObject.put("iTotalDisplayRecords", 0); //显示的行数,这个要和上面
        return jsonObject.toString();
    }
}
