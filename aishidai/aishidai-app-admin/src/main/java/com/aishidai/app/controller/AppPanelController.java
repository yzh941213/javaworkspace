package com.aishidai.app.controller;

import com.aishidai.app.model.pojo.AppPanelDO;
import com.aishidai.app.model.pojo.AttributeDO;
import com.aishidai.app.model.query.QueryAttrbute;
import com.aishidai.app.service.AppPanelService;
import com.aishidai.app.service.AttributeService;
import com.aishidai.common.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("manage/appPanel")
public class AppPanelController {

    @Autowired
    AppPanelService appPanelService;


    @GetMapping(value = "getAll")
    public JsonResult getAll(){

        return  JsonResult.buildSuccess(appPanelService.getAll());
    }



    @GetMapping(value = "update")
    public JsonResult update(AppPanelDO  appPanelDO){
        try {
            return JsonResult.buildSuccess( appPanelService.update(appPanelDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }



    @GetMapping(value = "del")
    public JsonResult del(Long attributeId){
        try {
            return JsonResult.buildSuccess(null);
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "add")
    public JsonResult add(AppPanelDO appPanelDO){
        try {
            return JsonResult.buildSuccess(appPanelService.add(appPanelDO));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }

    @GetMapping(value = "getById")
    public JsonResult getById(Long attributeId){
        try {
            return JsonResult.buildSuccess(appPanelService.getById(attributeId));
        }catch (Exception e){
            return JsonResult.buidException(e);
        }

    }
}
