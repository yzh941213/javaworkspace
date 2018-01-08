package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.ReturnOrderManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ReOrderRecordDO;
import com.zhezhuo.model.entity.ReturnOrderDO;
import com.zhezhuo.model.query.ItemQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/22.
 */
@Controller
@RequestMapping("/manager/return")
public class ReturnOrderController {

    @Autowired
    ReturnOrderManager returnOrderManager;

    @RequestMapping(value = {"/status.do", "/service/checked.do", "/logistics/checked.do", "/logistics/consult.do",
            "/finance/consult.do", "/finance/checked.do", "/finance/off.do", "/seller/reject.do"})
    @ResponseBody
    public String operateStatus(@RequestParam("data") String data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        try {
            ReOrderRecordDO reOrderRecordDO = JSONObject.parseObject(data, ReOrderRecordDO.class);
            if (reOrderRecordDO == null) {
                jsonObject.put("message", "参数错误");
                jsonObject.put("data", -1);
                return jsonObject.toString();
            }
            Result<Long> result = returnOrderManager.operateStatus(reOrderRecordDO);
            if (result != null && result.isSuccess()) {
                jsonObject.put("success", true);
                jsonObject.put("message", result.getSuccessInfo());
                jsonObject.put("data", result.getResult());
                return jsonObject.toString();
            }
            jsonObject.put("message", result.getErrorInfo());
            jsonObject.put("data", result.getResult());
            return jsonObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("message", "操作失败");
            jsonObject.put("data", -1);
            return jsonObject.toString();
        }
    }

    @RequestMapping("/record.do")
    @ResponseBody
    public String queryRecordList(@RequestParam("returnOrderId") long returnOrderId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        List<ReOrderRecordDO> recordDOs = returnOrderManager.queryRecord(returnOrderId);
        if (recordDOs == null) {
            jsonObject.put("message", "查询失败");
            jsonObject.put("data", "");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", recordDOs);
        return jsonObject.toString();
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public String queryReOrList(@RequestParam(value = "userId",defaultValue = "0", required = false) long userId,
                                @RequestParam(value = "aoData", defaultValue = "", required = false) String aoData,
                                @RequestParam(value = "sort", defaultValue = "returnOrderId", required = false) String sort,
                                @RequestParam(value = "order", defaultValue = "desc", required = false) String order,
                                @RequestParam(value = "status", defaultValue = "-1", required = false) int status,
                                @RequestParam(value = "search", defaultValue = "", required = false) String search) {

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

        ItemQuery query = new ItemQuery();
        query.setStartRow(iDisplayStart);
        query.setPageSize(iDisplayLength);
        query.setOrder(order);

        if (StringUtils.isNotEmpty(search)) {
            query.setSearch("%" + search + "%");
        } else {
            query.setSearch(search);
        }

        List<Integer> statuss = new ArrayList<Integer>();
        if (status >= 0) {
            statuss.add(status);
        } else {
            statuss.add(0);
            statuss.add(1);
            statuss.add(2);
            statuss.add(3);
            statuss.add(4);
            statuss.add(5);
            statuss.add(6);
            statuss.add(7);
            statuss.add(8);
            statuss.add(9);
        }

        query.setStatus(statuss);
        query.setUserId(userId);
        query.setSortField(sort);
        List<ReturnOrderDO> recordDOs = returnOrderManager.queryReturnOrderList(query);
        if (recordDOs == null) {
            jsonObject.put("message", "查询失败");
            jsonObject.put("data", "");
            jsonObject.put("iTotalRecords", 0); //实际的行数
            jsonObject.put("iTotalDisplayRecords", 0); //显示的行数,这个要和上面
            jsonObject.put("aaData", "");
            return jsonObject.toString();
        }
        jsonObject.put("message", "查询成功");
        jsonObject.put("iTotalRecords", query.getTotalItem()); //实际的行数
        jsonObject.put("iTotalDisplayRecords", query.getTotalItem()); //显示的行数,这个要和上面
        jsonObject.put("aaData", recordDOs);
        jsonObject.put("success", true);
        return jsonObject.toString();
    }

    @RequestMapping("/detail.do")
    @ResponseBody
    public String queryReOrDetail(@RequestParam("returnOrderId") long returnOrderId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        ReturnOrderDO recordDO = returnOrderManager.queryReturnOrderDetail(returnOrderId);
        if (recordDO == null) {
            jsonObject.put("message", "查询失败");
            jsonObject.put("data", "");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", recordDO);
        return jsonObject.toString();
    }

}
