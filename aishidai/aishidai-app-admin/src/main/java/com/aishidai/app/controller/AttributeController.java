package com.aishidai.app.controller;

import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.query.QueryAttrbute;
import com.aishidai.app.service.AttributeService;
import com.aishidai.common.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("manage/attribute")
public class AttributeController {
	
    @Autowired
    AttributeService attributeService;

    @GetMapping(value = "list")
    public JsonResult list(QueryAttrbute queryAttrbute){

        return  JsonResult.buildPaging(attributeService.queryList(queryAttrbute),queryAttrbute.getsEcho(),attributeService.queryListCount(queryAttrbute));
    }

    @GetMapping(value = "queryByAttr")
    public JsonResult queryByAttr(QueryAttrbute queryAttrbute){

        return  JsonResult.buildSuccess(attributeService.queryByObj(queryAttrbute));
    }
    @GetMapping(value = "all")
    public JsonResult getAll(){
       return JsonResult.buildSuccess(attributeService.getAll());
    }

    @GetMapping(value = "update")
    public JsonResult update(AttributeDO attributeDO){
        try {
            attributeDO.setUpdated(new Date());
            return JsonResult.buildSuccess( attributeService.update(attributeDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "detailsById")
    public JsonResult update(Long attributeId){
        try {
            return JsonResult.buildSuccess( attributeService.getDetailsById(attributeId));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "del")
    public JsonResult del(Long attributeId){
        try {
            return JsonResult.buildSuccess( attributeService.del(attributeId));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "add")
    public JsonResult add(AttributeDO attributeDO){
        try {
            return JsonResult.buildSuccess(attributeService.add(attributeDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "getById")
    public JsonResult getById(Long attributeId){
        try {
            return JsonResult.buildSuccess(attributeService.getById(attributeId));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }
}
