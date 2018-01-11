package com.aishidai.app.controller;

import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.query.QueryAttrbute;
import com.aishidai.app.model.query.QueryItem;
import com.aishidai.app.service.AttributeService;
import com.aishidai.common.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/attribute")
public class AttributeController {
	
    @Autowired
    AttributeService attributeService;

    @GetMapping(value = "list")
    public JsonResult list(QueryAttrbute queryAttrbute){

        return  JsonResult.buildSuccess(attributeService.queryList(queryAttrbute));
    }
    @GetMapping(value = "all")
    public JsonResult getAll(){
       return JsonResult.buildSuccess(attributeService.getAll());
    }

    @GetMapping(value = "update")
    public JsonResult update(AttributeDO attributeDO){

        return JsonResult.buildSuccess( attributeService.update(attributeDO));
    }

    @GetMapping(value = "add")
    public JsonResult add(AttributeDO attributeDO){

        return JsonResult.buildSuccess( attributeService.add(attributeDO));
    }
}
