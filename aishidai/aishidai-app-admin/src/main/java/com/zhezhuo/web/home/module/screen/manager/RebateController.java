package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.RebateManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.RebateDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/12/13.
 */
@Controller
@RequestMapping("/manager/rebate")
public class RebateController {


    @Autowired
    RebateManager rebateManager;


    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    @ResponseBody
    public String createRebateDO(@RequestParam(value = "number",defaultValue = "0") int number,
                                 @RequestParam(value = "name",defaultValue = "") String name,
                                 @RequestParam(value = "itemId",defaultValue = "0") long itemId,
                                 @RequestParam(value = "discount",defaultValue = "0.00") String discount,
                                 @RequestParam(value = "startTime",defaultValue = "") String startTime,
                                 @RequestParam(value = "endTime",defaultValue = "") String endTime,
                                 @RequestParam(value = "creater",defaultValue = "0") long creater) {

        RebateDO rebateDO = new RebateDO();
        rebateDO.setNumber(number);
        rebateDO.setName(name);
        rebateDO.setItemId(itemId);
        rebateDO.setDiscount(discount);
        rebateDO.setStartTime(startTime);
        rebateDO.setEndTime(endTime);
        rebateDO.setCreater(creater);

        Result<Long> result = rebateManager.createRebateDO(rebateDO);
        JSONObject jsonObject = new JSONObject();
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("success", false);
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", result.getErrorInfo());
        return jsonObject.toString();
    }

    @RequestMapping(value = {"/update.do","/del.do","/status.do"}, method = RequestMethod.POST)
    @ResponseBody
    public String updateRebateDO(@RequestParam(value = "number",defaultValue = "1") int number,
                                 @RequestParam(value = "rebateId",defaultValue = "0") long rebateId,
                                 @RequestParam(value = "name",defaultValue = "") String name,
                                 @RequestParam(value = "itemId",defaultValue = "0") long itemId,
                                 @RequestParam(value = "discount",defaultValue = "") String discount,
                                 @RequestParam(value = "startTime",defaultValue = "") String startTime,
                                 @RequestParam(value = "endTime",defaultValue = "") String endTime,
                                 @RequestParam(value = "creater",defaultValue = "0") long creater,
                                 @RequestParam(value = "status",defaultValue = "0") int status,
                                 @RequestParam(value = "isDeleted",defaultValue = "0") int isDeleted) {

        RebateDO rebateDO = new RebateDO();
        rebateDO.setRebateId(rebateId);
        rebateDO.setStatus(status);
        rebateDO.setIsDeleted(isDeleted);
        rebateDO.setNumber(number);
        rebateDO.setName(name);
        rebateDO.setItemId(itemId);
        rebateDO.setDiscount(discount);
        rebateDO.setStartTime(startTime);
        rebateDO.setEndTime(endTime);
        rebateDO.setCreater(creater);

        Result<Integer> result = rebateManager.updateRebate(rebateDO);
        JSONObject jsonObject = new JSONObject();
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("success", false);
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", result.getErrorInfo());
        return jsonObject.toString();
    }

    @RequestMapping(value = {"/query.do"}, method = RequestMethod.GET)
    @ResponseBody
    public String queryRebateDOS() {

        Result<List<RebateDO>> result = rebateManager.queryRebates();
        JSONObject jsonObject = new JSONObject();
        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("data", result.getResult());
            jsonObject.put("message", result.getSuccessInfo());
            return jsonObject.toString();
        }
        jsonObject.put("success", false);
        jsonObject.put("data", result.getResult());
        jsonObject.put("message", result.getErrorInfo());
        return jsonObject.toString();
    }



}
