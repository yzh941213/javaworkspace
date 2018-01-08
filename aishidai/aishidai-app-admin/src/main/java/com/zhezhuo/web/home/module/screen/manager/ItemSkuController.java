package com.zhezhuo.web.home.module.screen.manager;

import com.alibaba.fastjson.JSONObject;
import com.zhezhuo.biz.manager.ItemSkuManager;
import com.zhezhuo.model.Result;
import com.zhezhuo.model.entity.ItemSkuDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 蝈蝈 on 2016/10/10.
 */
@Controller
@RequestMapping("/manager/item")
public class ItemSkuController {

    @Autowired
    ItemSkuManager itemSkuManager;

    @RequestMapping("/sku/detail.do")
    @ResponseBody
    public String queryItemDesc(@RequestParam("itemId") long itemId){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);
        Result<ItemSkuDO> result = itemSkuManager.queryItemSkuByItemId(itemId);

        if (result != null && result.isSuccess() ) {
            jsonObject.put("success", true);
            if (result.getResult() == null) {
                jsonObject.put("data", result.getResult());
            } else {
                jsonObject.put("data", result.getResult());
            }
            jsonObject.put("message", "query success");
            jsonObject.put("data", result.getResult());
            return jsonObject.toString();
        }
        jsonObject.put("success", false);
        jsonObject.put("message", "query failed");
        jsonObject.put("data", "");
        return jsonObject.toString();
    }

    @RequestMapping(value = {"/sku/edit.do","/sku/save.do"},method = RequestMethod.POST)
    @ResponseBody
    public String updateItemDesc(@RequestParam(value = "skuId", defaultValue = "0") long skuId,
                                @RequestParam(value = "itemId", defaultValue = "0") long itemId,
                                @RequestParam(value = "code", defaultValue = "") String code,
                                @RequestParam(value = "price", defaultValue = "0") double price,
                                @RequestParam(value = "stock", defaultValue = "0") int stock,
                                @RequestParam(value = "sale", defaultValue = "0") long sale,
                                @RequestParam(value = "isDefault", defaultValue = "0") int isDefault,
                                @RequestParam(value = "image", defaultValue = "") String image,
                                @RequestParam(value = "desc", defaultValue = "") String desc,
                                @RequestParam(value = "isDeleted", defaultValue = "0") long isDeleted){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", false);

        ItemSkuDO itemSkuDO = new ItemSkuDO();
        itemSkuDO.setSkuId(skuId);
        itemSkuDO.setItemId(itemId);
        itemSkuDO.setCode(code);
        itemSkuDO.setPrice(price);
        itemSkuDO.setStock(stock);
        itemSkuDO.setSale(sale);
        itemSkuDO.setIsDefault(isDefault);
        itemSkuDO.setDescription(desc);
        itemSkuDO.setImage(image);
        itemSkuDO.setIsDeleted(isDefault);
        itemSkuDO.setCreated(String.valueOf(System.currentTimeMillis() / 1000));
        itemSkuDO.setUpdated(String.valueOf(System.currentTimeMillis() / 1000));
        Result<Long> result = itemSkuManager.editItemSku(itemSkuDO);

        if (result != null && result.isSuccess()) {
            jsonObject.put("success", true);
            jsonObject.put("message", "operate success");
            jsonObject.put("data", result.getResult());
            return jsonObject.toString();
        }
        jsonObject.put("success", false);
        jsonObject.put("message", "operate failed");
        jsonObject.put("data", "");
        return jsonObject.toString();
    }

}
