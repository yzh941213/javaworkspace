package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.dao.PropertyDAO;
import com.zhezhuo.biz.manager.SkuManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.domain.SkuDetailDTO;
import com.zhezhuo.model.entity.SkuDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蝈蝈 on 2016/8/24.
 */
@Controller
@RequestMapping("/manager/sku")
public class SkuController {


    @Autowired
    private SkuManager skuManager;
    @Autowired
    private PropertyDAO propertyDAO;

    @RequestMapping("/list.do")
    @ResponseBody
    public String querySkuDOListByItemId(@RequestParam("itemId") long itemId) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        Result<List<SkuDetailDTO>> result = skuManager.querySkuDOList(itemId);
        if (result == null || !result.isSuccess() || result.getResult() == null) {
            jsonObject.put("message", "查询失败");
            return jsonObject.toString();
        }
        jsonObject.put("success", true);
        jsonObject.put("message", "查询成功");
        jsonObject.put("data", result.getResult());
        return jsonObject.toString();
    }

    @RequestMapping("/status.do")
    @ResponseBody
    public String updateSkuDOStatus(@RequestParam(value = "skuId",defaultValue = "0") long skuId,
                                    @RequestParam(value = "colorId",defaultValue = "0") long colorId,
                                    @RequestParam(value = "itemId",defaultValue = "0") long itemId,
                                    @RequestParam("status") int status) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        SkuDO skuDo = new SkuDO();
        skuDo.setSkuId(skuId);
        skuDo.setItemId(itemId);
        skuDo.setColourId(colorId);
        skuDo.setStatus(status);

        Result<Integer> result = skuManager.updateSkuDOStatus(skuDo);

        if (result == null || !result.isSuccess() || result.getResult() == null) {
            jsonObject.put("message", "操作失败");
            return jsonObject.toString();
        }

        jsonObject.put("success", true);
        jsonObject.put("message", "操作成功");
        return jsonObject.toString();
    }

    @RequestMapping(value = {"/edit.do", "/save.do"})
    @ResponseBody
    public String editSkuDO(@RequestParam("itemId") long itemId,
                            @RequestParam("sku") String sku) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        if (StringUtils.isBlank(sku)) {
            jsonObject.put("message", "参数错误");
            return jsonObject.toString();
        }
        try {
            List<SkuDO> skuDOs = JSONArray.parseArray(sku,SkuDO.class);
            Result<Integer> result = skuManager.editSkuDO(skuDOs,itemId);
            if (result == null || !result.isSuccess()) {
                jsonObject.put("message", "操作失败");
                return jsonObject.toString();
            }
            jsonObject.put("success", true);
            jsonObject.put("skuId", result.getResult());
            jsonObject.put("message", "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("success", false);
            jsonObject.put("message", "操作失败");
            return jsonObject.toString();
        }
        return jsonObject.toString();
    }
}
