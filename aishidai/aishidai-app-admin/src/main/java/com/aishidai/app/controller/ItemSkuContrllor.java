package com.aishidai.app.controller;
import com.aishidai.app.dao.ItemSkuDOMapper;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.pojo.ItemDO;
import com.aishidai.app.model.pojo.ItemSkuDO;
import com.aishidai.app.service.ItemSkuService;
import com.aishidai.common.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("manage/itemSku")
public class ItemSkuContrllor {

    @Autowired
    ItemSkuService itemSkuService;


    @GetMapping(value = "update")
    public JsonResult update(ItemSkuDO itemSkuDO){

        return JsonResult.buildSuccess( itemSkuService.update(itemSkuDO));
    }

    @GetMapping(value = "add")
    public JsonResult add(ItemSkuDO itemSkuDO){

        return JsonResult.buildSuccess( itemSkuService.add(itemSkuDO));
    }
}
